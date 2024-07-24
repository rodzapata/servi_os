package com.serviparamo.api_rest.service;

import com.serviparamo.api_rest.dto.RolDto;
import com.serviparamo.api_rest.entity.RolEntity;
import com.serviparamo.api_rest.repository.RolRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    private RolRespository repository;

    public List<RolDto> findAll() {
        List<RolDto> dtos = new ArrayList<>();
        List<RolEntity> entities = this.repository.findAll();

        for (RolEntity entity: entities) {
            dtos.add(RolDto.builder()
                    .id(entity.getId())
                    .name(entity.getTitle())
                    .build());
        }

        return dtos;
    }

    public boolean existRolById(Long id) {
        Optional<RolEntity> optionalRolEntity = this.repository.findById(id);
        return optionalRolEntity.isPresent();
    }

}
