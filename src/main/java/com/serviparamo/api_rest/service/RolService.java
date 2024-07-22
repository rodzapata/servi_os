package com.serviparamo.api_rest.service;

import com.serviparamo.api_rest.entity.RolEntity;
import com.serviparamo.api_rest.repository.RolRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolService {
    @Autowired
    private RolRespository repository;

    public boolean existRolById(Long id) {
        Optional<RolEntity> optionalRolEntity = this.repository.findById(id);
        return optionalRolEntity.isPresent();
    }

}
