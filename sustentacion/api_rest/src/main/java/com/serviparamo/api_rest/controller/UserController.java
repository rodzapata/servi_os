package com.serviparamo.api_rest.controller;

import com.serviparamo.api_rest.dto.LoginDto;
import com.serviparamo.api_rest.dto.ServerResponseDataDto;
import com.serviparamo.api_rest.dto.UserDto;
import com.serviparamo.api_rest.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/validar-credenciales")
    public boolean validarCredenciales(@RequestBody @Valid LoginDto dto) {
        return service.validarCredenciales(dto.getEmail(),dto.getPassword());
    }

    @PostMapping()
    public ServerResponseDataDto create(@RequestBody @Valid UserDto dto) {

        UserDto response = this.service.create(dto);

        return ServerResponseDataDto.builder()
                .data(response)
                .status(HttpStatus.OK.value())
                .message("Registro creado con exito")
                .build();

    }
    @GetMapping
    public ServerResponseDataDto findAll() {

        List<UserDto> dtos = this.service.findAll();

        return ServerResponseDataDto.builder()
                .data(dtos)
                .status(HttpStatus.OK.value())
                .message("Registro encontrados")
                .build();
    }

    @GetMapping("/{id}")
    public ServerResponseDataDto findById(@PathVariable("id") Long id) {

        UserDto dto = this.service.getById(id);

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
            @RequestBody @Valid UserDto newData
    ) {

        UserDto dto = this.service.updateById(id, newData);

        return ServerResponseDataDto.builder()
                .data(dto)
                .status(HttpStatus.OK.value())
                .message("Registro actualizado")
                .build();
    }

}
