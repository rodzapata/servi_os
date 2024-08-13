package com.serviparamo.api_rest.controller;

import com.serviparamo.api_rest.dto.ServiceOrderDto;
import com.serviparamo.api_rest.service.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-order")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    @GetMapping
    public List<ServiceOrderDto> getAll() {
        return serviceOrderService.getAll();
    }

    @GetMapping("/{id}")
    public ServiceOrderDto getById(@PathVariable Long id) {
        return serviceOrderService.getById(id);
    }

    @PostMapping
    public ServiceOrderDto create(@RequestBody ServiceOrderDto serviceOrderDto) {
        return serviceOrderService.create(serviceOrderDto);
    }

    @PutMapping("/{id}")
    public ServiceOrderDto update(@PathVariable Long id, @RequestBody ServiceOrderDto serviceOrderDto) {
        return serviceOrderService.update(id, serviceOrderDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceOrderService.delete(id);
    }
}
