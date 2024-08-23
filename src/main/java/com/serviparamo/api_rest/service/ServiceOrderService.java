package com.serviparamo.api_rest.service;

import com.serviparamo.api_rest.dto.ServiceOrderDetailDto;
import com.serviparamo.api_rest.dto.ServiceOrderDto;
import com.serviparamo.api_rest.dto.UserDto;
import com.serviparamo.api_rest.entity.RolEntity;
import com.serviparamo.api_rest.entity.ServiceOrderDetailEntity;
import com.serviparamo.api_rest.entity.ServiceOrderEntity;
import com.serviparamo.api_rest.entity.UserEntity;
import com.serviparamo.api_rest.exception.EmailNotValidException;
import com.serviparamo.api_rest.exception.ResourceNotFoundException;
import com.serviparamo.api_rest.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ServiceOrderDetailRepository serviceOrderDetailRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Transactional
    public List<ServiceOrderDto> getAll() {
        return serviceOrderRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ServiceOrderDto getById(Long id) {
        return serviceOrderRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new ResourceNotFoundException("ServiceOrder not found"));
    }

    @Transactional
    public ServiceOrderDto create(ServiceOrderDto serviceOrderDto) {
        ServiceOrderEntity serviceOrder = convertToEntity(serviceOrderDto);
        return convertToDto(serviceOrderRepository.save(serviceOrder));
    }


    @Transactional
    public ServiceOrderDto update(Long id, ServiceOrderDto serviceOrderDto) {
        ServiceOrderEntity serviceOrder = convertToEntity(serviceOrderDto);
        serviceOrder.setId(id);
        return convertToDto(serviceOrderRepository.save(serviceOrder));
    }

    @Transactional
    public void delete(Long id) {
        serviceOrderRepository.deleteById(id);
    }

    private ServiceOrderDto convertToDto(ServiceOrderEntity serviceOrder) {
        ServiceOrderDto dto = new ServiceOrderDto();
        dto.setId(serviceOrder.getId());
        dto.setCustomerId(serviceOrder.getCustomer().getId());
        dto.setDate(serviceOrder.getDate());
        dto.setCustomerFullName(serviceOrder.getCustomer().getFullName());
        dto.setEquipmentId(serviceOrder.getEquipment().getId());
        dto.setSerialNumber(serviceOrder.getEquipment().getSerialNumber());
        dto.setEquipmentTypeName(serviceOrder.getEquipment().getEquipmentType().getEquipmentTypeName());
        dto.setBrandName(serviceOrder.getEquipment().getBrand().getBrandName());
        dto.setRefrigerantName(serviceOrder.getEquipment().getRefrigerant().getRefrigerantName());
        dto.setDetails(serviceOrder.getDetails().stream()
                .map(this::convertDetailToDto)
                .collect(Collectors.toList()));
        return dto;
    }

    private ServiceOrderEntity convertToEntity(ServiceOrderDto dto) {
        ServiceOrderEntity serviceOrder = new ServiceOrderEntity();
        serviceOrder.setCustomer(customerRepository.findById(dto.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Customer not found")));
        serviceOrder.setEquipment(equipmentRepository.findById(dto.getEquipmentId()).orElseThrow(() -> new ResourceNotFoundException("Customer not found")));
        serviceOrder.setDate(dto.getDate());
        /*
        serviceOrder.setSerialNumber(dto.getSerialNumber());
        serviceOrder.setEquipmentTypeName(dto.getEquipmentTypeName());
        serviceOrder.setBrandName(dto.getBrandName());
        serviceOrder.setRefrigerantName(dto.getRefrigerantName());
        */
        serviceOrder.setDetails(dto.getDetails().stream()
                .map(detailDto -> convertDetailToEntity(detailDto, serviceOrder))
                .collect(Collectors.toList()));
        return serviceOrder;
    }

    private ServiceOrderDetailDto convertDetailToDto(ServiceOrderDetailEntity detail) {
        ServiceOrderDetailDto dto = new ServiceOrderDetailDto();
        dto.setId(detail.getId());
        dto.setActivityId(detail.getActivity().getId());
        dto.setDescription(detail.getDescription());
        /*
        dto.setEquipmentId(detail.getEquipment().getId());
        dto.setSerialNumber(detail.getEquipment().getSerialNumber());
        dto.setEquipmentTypeName(detail.getEquipment().getEquipmentType().getEquipmentTypeName());
        dto.setBrandName(detail.getEquipment().getBrand().getBrandName());
        dto.setRefrigerantName(detail.getEquipment().getRefrigerant().getRefrigerantName());

         */
        return dto;
    }

    private ServiceOrderDetailEntity convertDetailToEntity(ServiceOrderDetailDto dto, ServiceOrderEntity serviceOrder) {
        ServiceOrderDetailEntity detail = new ServiceOrderDetailEntity();
        detail.setServiceOrder(serviceOrder);
        detail.setActivity(activityRepository.findById(dto.getActivityId()).orElseThrow(() -> new ResourceNotFoundException("Activity not found")));
        //detail.setEquipment(equipmentRepository.findById(dto.getEquipmentId()).orElseThrow(() -> new ResourceNotFoundException("Equipment not found")));
        detail.setDescription(dto.getDescription());
        /*
        detail.setSerialNumber(dto.getSerialNumber());
        detail.setEquipmentTypeName(dto.getEquipmentTypeName());
        detail.setBrandName(dto.getBrandName());
        detail.setRefrigerantName(dto.getRefrigerantName());

         */
        return detail;
    }
}
