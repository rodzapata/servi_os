package com.serviparamo.api_rest.service;

import com.serviparamo.api_rest.dto.CustomerDto;
import com.serviparamo.api_rest.entity.CustomerEntity;
import com.serviparamo.api_rest.entity.RolEntity;
import com.serviparamo.api_rest.exception.EmailNotValidException;
import com.serviparamo.api_rest.exception.ResourceNotFoundException;
import com.serviparamo.api_rest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public boolean validateByEmail(String email) {
        CustomerEntity entity = this.repository.findByEmail(email);
        if(Objects.isNull(entity)) {
            return false;
        }
        return true;
    }
    public boolean existCustomerById(Long id) {
        Optional<CustomerEntity> optionalRolEntity = this.repository.findById(id);
        return optionalRolEntity.isPresent();
    }

    public CustomerDto create(CustomerDto dto) {
        //No se puede registrar un usuario con un correo ya registrado
        if(validateByEmail(dto.getEmail())) {
            throw new EmailNotValidException();
        }

        CustomerEntity entity = new CustomerEntity();
        entity.setFullName(dto.getFullName());
        entity.setBornDate(dto.getBornDate());
        entity.setState(dto.getState());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());
        entity = repository.save(entity);

        dto.setId(entity.getId());

        return dto;
    }

    public List<CustomerDto> findAll() {

        List<CustomerEntity> entities =  this.repository.findAll();
        List<CustomerDto> dtos = new ArrayList<>();

        for(int i = 0; i < entities.size(); i++) {
            CustomerEntity entity =  entities.get(i);
            CustomerDto dto = CustomerDto.builder()
                    .id(entity.getId())
                    .fullName(entity.getFullName())
                    .bornDate(entity.getBornDate())
                    .state(entity.getState())
                    .email(entity.getEmail())
                    .phone(entity.getPhone())
                    .address(entity.getAddress())
                    .city(entity.getCity())
                    .build();
            dtos.add(dto);
        }

        return dtos;
    }
    public CustomerDto getById(Long id) {

        CustomerEntity entity = this.repository.findById(id).get();
        CustomerDto dto = CustomerDto.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .bornDate(entity.getBornDate())
                .state(entity.getState())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .address(entity.getAddress())
                .city(entity.getCity())
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

    public CustomerDto updateById(Long id, CustomerDto newData) {
        if(id <= 0) {
            return null;
        }

        Optional<CustomerEntity> optEntity = this.repository.findById(id);

        if(!optEntity.isPresent()) {
            return null;
        }

        //Ya tienen internamente el id
        CustomerEntity entity = optEntity.get();

        entity.setFullName(newData.getFullName());
        entity.setBornDate(newData.getBornDate());
        entity.setState(newData.getState());
        entity.setEmail(newData.getEmail());
        entity.setPhone(newData.getPhone());
        entity.setAddress(newData.getAddress());
        entity.setCity(newData.getCity());

        this.repository.save(entity);

        newData.setId(entity.getId());

        return newData;
    }

}
