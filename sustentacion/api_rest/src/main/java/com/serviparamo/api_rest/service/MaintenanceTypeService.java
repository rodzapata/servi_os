package com.serviparamo.api_rest.service;

import com.serviparamo.api_rest.dto.MaintenanceTypeDto;
import com.serviparamo.api_rest.entity.MaintenanceTypeEntity;
import com.serviparamo.api_rest.repository.MaintenanceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MaintenanceTypeService {
    @Autowired
    private MaintenanceTypeRepository repository;


    public boolean validateByMaintenanceTypeName(String maintenanceTypeName) {
        MaintenanceTypeEntity entity = this.repository.findByMaintenanceTypeName(maintenanceTypeName);
        if(Objects.isNull(entity)) {
            return false;
        }
        return true;
    }


    public MaintenanceTypeDto create(MaintenanceTypeDto dto) {
        //No se puede registrar un refrigerante con un nombre ya registrado

        if(validateByMaintenanceTypeName(dto.getMaintenanceTypeName())) {
            //throw new ActivityNameNotValidException();
            throw new RuntimeException("no se puede crear un mantenimiento con un nombre ya registrado ");
        }

        MaintenanceTypeEntity entity = new MaintenanceTypeEntity();
        entity.setMaintenanceTypeName(dto.getMaintenanceTypeName());
        entity = repository.save(entity);

        dto.setId(entity.getId());

        return dto;
    }

    public List<MaintenanceTypeDto> findAll() {

        List<MaintenanceTypeEntity> entities =  this.repository.findAll();
        List<MaintenanceTypeDto> dtos = new ArrayList<>();

        for(int i = 0; i < entities.size(); i++) {
            MaintenanceTypeEntity entity =  entities.get(i);
            MaintenanceTypeDto dto = MaintenanceTypeDto.builder()
                    .id(entity.getId())
                    .maintenanceTypeName(entity.getMaintenanceTypeName())
                    .build();
            dtos.add(dto);
        }

        return dtos;
    }
    public MaintenanceTypeDto getById(Long id) {

        MaintenanceTypeEntity entity = this.repository.findById(id).get();
        MaintenanceTypeDto dto = MaintenanceTypeDto.builder()
                .id(entity.getId())
                .maintenanceTypeName(entity.getMaintenanceTypeName())
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

    public MaintenanceTypeDto updateById(Long id, MaintenanceTypeDto newData) {
        if(id <= 0) {
            return null;
        }

        Optional<MaintenanceTypeEntity> optEntity = this.repository.findById(id);

        if(!optEntity.isPresent()) {
            return null;
        }

        //Ya tienen internamente el id
        MaintenanceTypeEntity entity = optEntity.get();

        entity.setMaintenanceTypeName(newData.getMaintenanceTypeName());
        this.repository.save(entity);

        newData.setId(entity.getId());

        return newData;
    }


}
