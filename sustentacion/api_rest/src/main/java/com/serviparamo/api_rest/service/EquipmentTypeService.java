package com.serviparamo.api_rest.service;

import com.serviparamo.api_rest.dto.EquipmentTypeDto;
import com.serviparamo.api_rest.entity.EquipmentTypeEntity;
import com.serviparamo.api_rest.exception.EquipmentTypeNameNotValidException;
import com.serviparamo.api_rest.repository.EquipmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EquipmentTypeService {
    @Autowired
    private EquipmentTypeRepository repository;


    public boolean validateByEquipmentTypeName(String equipmentTypeName) {
        EquipmentTypeEntity entity = this.repository.findByEquipmentTypeName(equipmentTypeName);
        if(Objects.isNull(entity)) {
            return false;
        }
        return true;
    }
    public EquipmentTypeDto create(EquipmentTypeDto dto) {
        //No se puede registrar un refrigerante con un nombre ya registrado

        if(validateByEquipmentTypeName(dto.getEquipmentTypeName())) {
            throw new EquipmentTypeNameNotValidException();
        }

        EquipmentTypeEntity entity = new EquipmentTypeEntity();
        entity.setEquipmentTypeName(dto.getEquipmentTypeName());
        entity = repository.save(entity);

        dto.setId(entity.getId());

        return dto;
    }
    public List<EquipmentTypeDto> findAll() {

        List<EquipmentTypeEntity> entities =  this.repository.findAll();
        List<EquipmentTypeDto> dtos = new ArrayList<>();

        for(int i = 0; i < entities.size(); i++) {
            EquipmentTypeEntity entity =  entities.get(i);
            EquipmentTypeDto dto = EquipmentTypeDto.builder()
                    .id(entity.getId())
                    .equipmentTypeName(entity.getEquipmentTypeName())
                    .build();
            dtos.add(dto);
        }

        return dtos;
    }
    public EquipmentTypeDto getById(Long id) {

        EquipmentTypeEntity entity = this.repository.findById(id).get();
        EquipmentTypeDto dto = EquipmentTypeDto.builder()
                .id(entity.getId())
                .equipmentTypeName(entity.getEquipmentTypeName())
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

    public EquipmentTypeDto updateById(Long id, EquipmentTypeDto newData) {
        if(id <= 0) {
            return null;
        }

        Optional<EquipmentTypeEntity> optEntity = this.repository.findById(id);

        if(!optEntity.isPresent()) {
            return null;
        }

        //Ya tienen internamente el id
        EquipmentTypeEntity entity = optEntity.get();

        entity.setEquipmentTypeName(newData.getEquipmentTypeName());

        this.repository.save(entity);

        newData.setId(entity.getId());

        return newData;
    }


}
