package com.serviparamo.api_rest.service;

import com.serviparamo.api_rest.dto.EquipmentDto;
import com.serviparamo.api_rest.entity.CustomerEntity;
import com.serviparamo.api_rest.entity.EquipmentEntity;
import com.serviparamo.api_rest.exception.ResourceNotFoundException;
import com.serviparamo.api_rest.exception.SerialNumberNotValidException;
import com.serviparamo.api_rest.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepository repository;
    @Autowired
    private CustomerService customerService;
    public boolean validateBySerialNumber(String serialNumber) {
        EquipmentEntity entity = this.repository.findBySerialNumber(serialNumber);
        if(Objects.isNull(entity)) {
            return false;
        }
        return true;
    }

    public EquipmentDto create(EquipmentDto dto) {
        //No se puede registrar un numero de serial ya registrado
        if(validateBySerialNumber(dto.getSerialNumber())) {
            throw new SerialNumberNotValidException();
        }

        //No se puede registrar un Equipo sin un Cliente previamente registrado
        if(!customerService.existCustomerById(dto.getCustomerId())) {
            throw new ResourceNotFoundException();
        }


        EquipmentEntity entity = new EquipmentEntity();
        entity.setSerialNumber(dto.getSerialNumber());
        entity.setInstallationDate(dto.getInstallationDate());
        entity.setLastMaintenanceDate(dto.getLastMaintenanceDate());

        CustomerEntity customer = new CustomerEntity();
        customer.setId(dto.getCustomerId());
        entity.setCustomer(customer);
        entity = repository.save(entity);

        dto.setId(entity.getId());
        return dto;
    }
    public List<EquipmentDto> findAll() {

        List<EquipmentEntity> entities =  this.repository.findAll();
        List<EquipmentDto> dtos = new ArrayList<>();

        for(int i = 0; i < entities.size(); i++) {
            EquipmentEntity entity =  entities.get(i);
            EquipmentDto dto = EquipmentDto.builder()
                    .id(entity.getId())
                    .serialNumber(entity.getSerialNumber())
                    .installationDate(entity.getInstallationDate())
                    .lastMaintenanceDate(entity.getInstallationDate())
                    .customerId(entity.getCustomer().getId())
                    .customerFullName(entity.getCustomer().getFullName())
                    .customerPhone(entity.getCustomer().getPhone())
                    .build();
            dtos.add(dto);
        }

        return dtos;
    }

    public EquipmentDto getById(Long id) {

        EquipmentEntity entity = this.repository.findById(id).get();
        EquipmentDto dto = EquipmentDto.builder()
                .id(entity.getId())
                .serialNumber(entity.getSerialNumber())
                .installationDate(entity.getInstallationDate())
                .lastMaintenanceDate(entity.getInstallationDate())
                .customerId(entity.getCustomer().getId())
                .customerFullName(entity.getCustomer().getFullName())
                .customerPhone(entity.getCustomer().getPhone())
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

    public EquipmentDto updateById(Long id, EquipmentDto newData) {
        if(id <= 0) {
            return null;
        }

        Optional<EquipmentEntity> optEntity = this.repository.findById(id);

        if(!optEntity.isPresent()) {
            return null;
        }

        //Ya tienen internamente el id
        EquipmentEntity entity = optEntity.get();

        entity.setSerialNumber(newData.getSerialNumber());
        entity.setInstallationDate(newData.getInstallationDate());
        entity.setLastMaintenanceDate(newData.getLastMaintenanceDate());

        CustomerEntity customer = new CustomerEntity();
        customer.setId(newData.getCustomerId());
        entity.setCustomer(customer);

        this.repository.save(entity);

        newData.setId(entity.getId());

        return newData;
    }

}
