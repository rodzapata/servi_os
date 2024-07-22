package com.serviparamo.api_rest.service;

import com.serviparamo.api_rest.dto.UserDto;
import com.serviparamo.api_rest.entity.RolEntity;
import com.serviparamo.api_rest.entity.UserEntity;
import com.serviparamo.api_rest.exception.EmailNotValidException;
import com.serviparamo.api_rest.exception.ResourceNotFoundException;
import com.serviparamo.api_rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private RolService rolService;
    public boolean validateByEmail(String email) {
        UserEntity entity = this.repository.findByEmail(email);
        if(Objects.isNull(entity)) {
            return false;
        }
        return true;
    }

    public UserDto create(UserDto dto) {
        //No se puede registrar un usuario con un correo ya registrado
        if(validateByEmail(dto.getEmail())) {
            throw new EmailNotValidException();
        }

        //No se puede registrar un usuario sin un rol previamente registrado
        if(!rolService.existRolById(dto.getRolId())) {
            throw new ResourceNotFoundException();
        }

        UserEntity entity = new UserEntity();
        entity.setFullName(dto.getFullName());
        entity.setBornDate(dto.getBornDate());
        entity.setState(dto.getState());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setAvatar(dto.getAvatar());
        entity.setPassword(dto.getPassword());
        //entity.setPassword("1234");
        RolEntity rol = new RolEntity();
        rol.setId(dto.getRolId());
        entity.setRol(rol);
        entity = repository.save(entity);

        dto.setId(entity.getId());
        return dto;
    }

    public List<UserDto> findAll() {

        List<UserEntity> entities =  this.repository.findAll();
        List<UserDto> dtos = new ArrayList<>();

        for(int i = 0; i < entities.size(); i++) {
            UserEntity entity =  entities.get(i);
            UserDto dto = UserDto.builder()
                    .id(entity.getId())
                    .fullName(entity.getFullName())
                    .bornDate(entity.getBornDate())
                    .state(entity.getState())
                    .email(entity.getEmail())
                    .phone(entity.getPhone())
                    .avatar(entity.getAvatar())
                    .password(entity.getPassword())
                    .rolId(entity.getRol().getId())
                    .rolName(entity.getRol().getTitle())
                    .build();
            dtos.add(dto);
        }

        return dtos;
    }

    public UserDto getById(Long id) {

        UserEntity entity = this.repository.findById(id).get();
        UserDto dto = UserDto.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .bornDate(entity.getBornDate())
                .state(entity.getState())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .avatar(entity.getAvatar())
                .rolId(entity.getRol().getId())
                .rolName(entity.getRol().getTitle())
                .build();

        return dto;
    }

    public boolean deleteById(Long id) {
        if(id <= 0) {
            return false;
        }

        if(!this.repository.findById(id).isPresent()) {
            return false;
        }

        this.repository.deleteById(id);
        return true;
    }

    public UserDto updateById(Long id, UserDto newData) {
        if(id <= 0) {
            return null;
        }

        Optional<UserEntity> optEntity = this.repository.findById(id);

        if(!optEntity.isPresent()) {
            return null;
        }

        //Ya tienen internamente el id
        UserEntity entity = optEntity.get();

        entity.setFullName(newData.getFullName());
        entity.setBornDate(newData.getBornDate());
        entity.setState(newData.getState());
        entity.setEmail(newData.getEmail());
        entity.setPhone(newData.getPhone());
        entity.setAvatar(newData.getAvatar());
        entity.setPassword(newData.getPassword());

        RolEntity rol = new RolEntity();
        rol.setId(newData.getRolId());
        entity.setRol(rol);

        this.repository.save(entity);

        newData.setId(entity.getId());

        return newData;
    }

}
