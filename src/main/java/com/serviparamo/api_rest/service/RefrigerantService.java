package com.serviparamo.api_rest.service;

import com.serviparamo.api_rest.dto.RefrigerantDto;
import com.serviparamo.api_rest.entity.RefrigerantEntity;
import com.serviparamo.api_rest.exception.RefrigerantNameNotValidException;
import com.serviparamo.api_rest.repository.RefrigerantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RefrigerantService {
    @Autowired
    private RefrigerantRepository repository;


    public boolean validateByRefrigerantName(String refrigeratName) {
        RefrigerantEntity entity = this.repository.findByRefrigerantName(refrigeratName);
        if(Objects.isNull(entity)) {
            return false;
        }
        return true;
    }

    public RefrigerantDto create(RefrigerantDto dto) {
        //No se puede registrar un refrigerante con un nombre ya registrado

        if(validateByRefrigerantName(dto.getRefrigerantName())) {
            throw new RefrigerantNameNotValidException();
        }

        RefrigerantEntity entity = new RefrigerantEntity();
        entity.setRefrigerantName(dto.getRefrigerantName());
        entity = repository.save(entity);

        dto.setId(entity.getId());

        return dto;
    }

    public List<RefrigerantDto> findAll() {

        List<RefrigerantEntity> entities =  this.repository.findAll();
        List<RefrigerantDto> dtos = new ArrayList<>();

        for(int i = 0; i < entities.size(); i++) {
            RefrigerantEntity entity =  entities.get(i);
            RefrigerantDto dto = RefrigerantDto.builder()
                    .id(entity.getId())
                    .refrigerantName(entity.getRefrigerantName())
                    .build();
            dtos.add(dto);
        }

        return dtos;
    }
    public RefrigerantDto getById(Long id) {

        RefrigerantEntity entity = this.repository.findById(id).get();
        RefrigerantDto dto = RefrigerantDto.builder()
                .id(entity.getId())
                .refrigerantName(entity.getRefrigerantName())
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

    public RefrigerantDto updateById(Long id, RefrigerantDto newData) {
        if(id <= 0) {
            return null;
        }

        Optional<RefrigerantEntity> optEntity = this.repository.findById(id);

        if(!optEntity.isPresent()) {
            return null;
        }

        //Ya tienen internamente el id
        RefrigerantEntity entity = optEntity.get();

        entity.setRefrigerantName(newData.getRefrigerantName());

        this.repository.save(entity);

        newData.setId(entity.getId());

        return newData;
    }


}
