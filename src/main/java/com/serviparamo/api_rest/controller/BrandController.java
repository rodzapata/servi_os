package com.serviparamo.api_rest.controller;

import com.serviparamo.api_rest.dto.BrandDto;
import com.serviparamo.api_rest.dto.ServerResponseDataDto;
import com.serviparamo.api_rest.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")

public class BrandController {
    @Autowired
    private BrandService service;

    @PostMapping()
    public ServerResponseDataDto create(@RequestBody @Valid BrandDto dto) {

        BrandDto response = this.service.create(dto);

        return ServerResponseDataDto.builder()
                .data(response)
                .status(HttpStatus.OK.value())
                .message("Registro creado con exito")
                .build();

    }
    @GetMapping
    public ServerResponseDataDto findAll() {

        List<BrandDto> dtos = this.service.findAll();

        return ServerResponseDataDto.builder()
                .data(dtos)
                .status(HttpStatus.OK.value())
                .message("Registro encontrados")
                .build();
    }

    @GetMapping("/{id}")
    public ServerResponseDataDto findById(@PathVariable("id") Long id) {

        BrandDto dto = this.service.getById(id);

        return ServerResponseDataDto.builder()
                .data(dto)
                .status(HttpStatus.OK.value())
                .message("Registro encontrado")
                .build();
    }
    @DeleteMapping("/{id}")
    public ServerResponseDataDto deleteById(@PathVariable("id") Long id){
        return ServerResponseDataDto.builder()
                .data(this.service.deleteById(id))
                .status(HttpStatus.OK.value())
                .message("Registro eliminado")
                .build();
    }
    @PutMapping("/{id}")
    public ServerResponseDataDto updateById(
            @PathVariable("id") Long id,
            @RequestBody @Valid BrandDto newData
    ) {

        BrandDto dto = this.service.updateById(id, newData);

        return ServerResponseDataDto.builder()
                .data(dto)
                .status(HttpStatus.OK.value())
                .message("Registro actualizado")
                .build();
    }

}
