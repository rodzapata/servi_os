package com.serviparamo.api_rest.service;

import com.serviparamo.api_rest.dto.SpareDto;
import com.serviparamo.api_rest.entity.SpareEntity;
import com.serviparamo.api_rest.exception.SpareNameNotValidException;
import com.serviparamo.api_rest.repository.SpareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SpareService {
    @Autowired
    private SpareRepository repository;


    public boolean validateBySpareName(String spareName) {
        SpareEntity entity = this.repository.findBySpareName(spareName);
        if(Objects.isNull(entity)) {
            return false;
        }
        return true;
    }
    public SpareDto create(SpareDto dto) {
        //No se puede registrar un repuesto con un nombre ya registrado

        if(validateBySpareName(dto.getSpareName())) {
            throw new SpareNameNotValidException();
        }

        SpareEntity entity = new SpareEntity();
        entity.setSpareName(dto.getSpareName());
        entity = repository.save(entity);

        dto.setId(entity.getId());

        return dto;
    }

    public List<SpareDto> findAll() {

        List<SpareEntity> entities =  this.repository.findAll();
        List<SpareDto> dtos = new ArrayList<>();

        for(int i = 0; i < entities.size(); i++) {
            SpareEntity entity =  entities.get(i);
            SpareDto dto = SpareDto.builder()
                    .id(entity.getId())
                    .spareName(entity.getSpareName())
                    .build();
            dtos.add(dto);
        }

        return dtos;
    }
    public SpareDto getById(Long id) {

        SpareEntity entity = this.repository.findById(id).get();
        SpareDto dto = SpareDto.builder()
                .id(entity.getId())
                .spareName(entity.getSpareName())
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

    public SpareDto updateById(Long id, SpareDto newData) {
        if(id <= 0) {
            return null;
        }

        Optional<SpareEntity> optEntity = this.repository.findById(id);

        if(!optEntity.isPresent()) {
            return null;
        }

        //Ya tienen internamente el id
        SpareEntity entity = optEntity.get();

        entity.setSpareName(newData.getSpareName());

        this.repository.save(entity);

        newData.setId(entity.getId());

        return newData;
    }


}
