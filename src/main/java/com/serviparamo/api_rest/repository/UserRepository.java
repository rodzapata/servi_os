package com.serviparamo.api_rest.repository;

import com.serviparamo.api_rest.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends
        JpaRepository<UserEntity, Long>,
        JpaSpecificationExecutor<UserEntity> {

    UserEntity findByEmail(String email);
}

