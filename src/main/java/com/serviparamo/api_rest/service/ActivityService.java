package com.serviparamo.api_rest.service;

import com.serviparamo.api_rest.dto.ActivityDto;
import com.serviparamo.api_rest.entity.ActivityEntity;
import com.serviparamo.api_rest.exception.ActivityNameNotValidException;
import com.serviparamo.api_rest.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository repository;


    public boolean validateByActivityName(String activityName) {
        ActivityEntity entity = this.repository.findByActivityName(activityName);
        if(Objects.isNull(entity)) {
            return false;
        }
        return true;
    }
    public ActivityDto create(ActivityDto dto) {
        //No se puede registrar un refrigerante con un nombre ya registrado

        if(validateByActivityName(dto.getActivityName())) {
            throw new ActivityNameNotValidException();
        }

        ActivityEntity entity = new ActivityEntity();
        entity.setActivityName(dto.getActivityName());
        entity = repository.save(entity);

        dto.setId(entity.getId());

        return dto;
    }

    public List<ActivityDto> findAll() {

        List<ActivityEntity> entities =  this.repository.findAll();
        List<ActivityDto> dtos = new ArrayList<>();

        for(int i = 0; i < entities.size(); i++) {
            ActivityEntity entity =  entities.get(i);
            ActivityDto dto = ActivityDto.builder()
                    .id(entity.getId())
                    .activityName(entity.getActivityName())
                    .build();
            dtos.add(dto);
        }

        return dtos;
    }
    public ActivityDto getById(Long id) {

        ActivityEntity entity = this.repository.findById(id).get();
        ActivityDto dto = ActivityDto.builder()
                .id(entity.getId())
                .activityName(entity.getActivityName())
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

    public ActivityDto updateById(Long id, ActivityDto newData) {
        if(id <= 0) {
            return null;
        }

        Optional<ActivityEntity> optEntity = this.repository.findById(id);

        if(!optEntity.isPresent()) {
            return null;
        }

        //Ya tienen internamente el id
        ActivityEntity entity = optEntity.get();

        entity.setActivityName(newData.getActivityName());

        this.repository.save(entity);

        newData.setId(entity.getId());

        return newData;
    }


}
