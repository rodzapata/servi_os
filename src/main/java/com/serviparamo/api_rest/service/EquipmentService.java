package com.serviparamo.api_rest.service;

import com.serviparamo.api_rest.dto.EquipmentDto;
import com.serviparamo.api_rest.entity.*;
import com.serviparamo.api_rest.exception.CustomerNotFoundException;
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

    @Autowired
    private EquipmentTypeService equipmentTypeService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private RefrigerantService refrigerantService;

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
            throw new CustomerNotFoundException();
        }


        EquipmentEntity entity = new EquipmentEntity();
        entity.setSerialNumber(dto.getSerialNumber());
        entity.setInstallationDate(dto.getInstallationDate());
        entity.setLastMaintenanceDate(dto.getLastMaintenanceDate());

        CustomerEntity customer = new CustomerEntity();
        customer.setId(dto.getCustomerId());
        entity.setCustomer(customer);

        EquipmentTypeEntity equipmentType= new EquipmentTypeEntity();
        equipmentType.setId(dto.getEquipmentTypeId());
        entity.setEquipmentType(equipmentType);

        BrandEntity brand =new BrandEntity();
        brand.setId(dto.getBrandId());
        entity.setBrand(brand);

        RefrigerantEntity refrigerant= new RefrigerantEntity();
        refrigerant.setId(dto.getBrandId());
        entity.setRefrigerant(refrigerant);

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
                    .equipmentTypeId(entity.getEquipmentType().getId())
                    .equipmentTypeName(entity.getEquipmentType().getEquipmentTypeName())
                    .brandId(entity.getBrand().getId())
                    .brandName(entity.getBrand().getBrandName())
                    .refrigerantId(entity.getRefrigerant().getId())
                    .refrigerantName(entity.getRefrigerant().getRefrigerantName())
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
                .equipmentTypeId(entity.getEquipmentType().getId())
                .equipmentTypeName(entity.getEquipmentType().getEquipmentTypeName())
                .brandId(entity.getBrand().getId())
                .brandName(entity.getBrand().getBrandName())
                .refrigerantId(entity.getRefrigerant().getId())
                .refrigerantName(entity.getRefrigerant().getRefrigerantName())
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

        EquipmentTypeEntity equipmentType = new EquipmentTypeEntity();
        equipmentType.setId(newData.getEquipmentTypeId());
        entity.setEquipmentType(equipmentType);

        BrandEntity brand=new BrandEntity();
        brand.setId(newData.getBrandId());
        entity.setBrand(brand);

        RefrigerantEntity refrigerant=new RefrigerantEntity();
        refrigerant.setId(newData.getRefrigerantId());
        entity.setRefrigerant(refrigerant);

        this.repository.save(entity);

        newData.setId(entity.getId());
        return newData;
    }

}
