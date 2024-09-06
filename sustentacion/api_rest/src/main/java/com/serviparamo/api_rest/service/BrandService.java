package com.serviparamo.api_rest.service;

import com.serviparamo.api_rest.dto.BrandDto;
import com.serviparamo.api_rest.entity.BrandEntity;
import com.serviparamo.api_rest.exception.BrandNameNotValidException;
import com.serviparamo.api_rest.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    private BrandRepository repository;


    public boolean validateByBrandName(String brandName) {
        BrandEntity entity = this.repository.findByBrandName(brandName);
        if(Objects.isNull(entity)) {
            return false;
        }
        return true;
    }
    public BrandDto create(BrandDto dto) {
        //No se puede registrar un refrigerante con un nombre ya registrado

        if(validateByBrandName(dto.getBrandName())) {
            throw new BrandNameNotValidException();
        }

        BrandEntity entity = new BrandEntity();
        entity.setBrandName(dto.getBrandName());
        entity = repository.save(entity);

        dto.setId(entity.getId());

        return dto;
    }

    public List<BrandDto> findAll() {

        List<BrandEntity> entities =  this.repository.findAll();
        List<BrandDto> dtos = new ArrayList<>();

        for(int i = 0; i < entities.size(); i++) {
            BrandEntity entity =  entities.get(i);
            BrandDto dto = BrandDto.builder()
                    .id(entity.getId())
                    .brandName(entity.getBrandName())
                    .build();
            dtos.add(dto);
        }

        return dtos;
    }
    public BrandDto getById(Long id) {

        BrandEntity entity = this.repository.findById(id).get();
        BrandDto dto = BrandDto.builder()
                .id(entity.getId())
                .brandName(entity.getBrandName())
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

    public BrandDto updateById(Long id, BrandDto newData) {
        if(id <= 0) {
            return null;
        }

        Optional<BrandEntity> optEntity = this.repository.findById(id);

        if(!optEntity.isPresent()) {
            return null;
        }

        //Ya tienen internamente el id
        BrandEntity entity = optEntity.get();

        entity.setBrandName(newData.getBrandName());

        this.repository.save(entity);

        newData.setId(entity.getId());

        return newData;
    }


}
