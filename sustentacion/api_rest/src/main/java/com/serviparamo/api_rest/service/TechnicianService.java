package com.serviparamo.api_rest.service;

import com.serviparamo.api_rest.dto.TechnicianDto;
import com.serviparamo.api_rest.entity.TechnicianEntity;
import com.serviparamo.api_rest.exception.EmailNotValidException;
import com.serviparamo.api_rest.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TechnicianService {
    @Autowired
    private TechnicianRepository repository;

    public boolean validateByEmail(String email) {
        TechnicianEntity entity = this.repository.findByEmail(email);
        if(Objects.isNull(entity)) {
            return false;
        }
        return true;
    }
    public boolean existTechnicianById(Long id) {
        Optional<TechnicianEntity> optionalTechnicianEntity = this.repository.findById(id);
        return optionalTechnicianEntity.isPresent();
    }

    public TechnicianDto create(TechnicianDto dto) {
        //No se puede registrar un usuario con un correo ya registrado
        if(validateByEmail(dto.getEmail())) {
            throw new EmailNotValidException();
        }

        TechnicianEntity entity = new TechnicianEntity();
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setHireDate(dto.getHireDate());
        entity = repository.save(entity);

        dto.setId(entity.getId());

        return dto;
    }

    public List<TechnicianDto> findAll() {

        List<TechnicianEntity> entities =  this.repository.findAll();
        List<TechnicianDto> dtos = new ArrayList<>();

        for(int i = 0; i < entities.size(); i++) {
            TechnicianEntity entity =  entities.get(i);
            TechnicianDto dto = TechnicianDto.builder()
                    .id(entity.getId())
                    .fullName(entity.getFullName())
                    .email(entity.getEmail())
                    .phone(entity.getPhone())
                    .hireDate(entity.getHireDate())
                    .build();
            dtos.add(dto);
        }

        return dtos;
    }
    public TechnicianDto getById(Long id) {

        TechnicianEntity entity = this.repository.findById(id).get();
        TechnicianDto dto = TechnicianDto.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .hireDate(entity.getHireDate())
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

    public TechnicianDto updateById(Long id, TechnicianDto newData) {
        if(id <= 0) {
            return null;
        }

        Optional<TechnicianEntity> optEntity = this.repository.findById(id);

        if(!optEntity.isPresent()) {
            return null;
        }

        //Ya tienen internamente el id
        TechnicianEntity entity = optEntity.get();

        entity.setFullName(newData.getFullName());
        entity.setEmail(newData.getEmail());
        entity.setPhone(newData.getPhone());
        entity.setHireDate(newData.getHireDate());

        this.repository.save(entity);

        newData.setId(entity.getId());

        return newData;
    }

}
