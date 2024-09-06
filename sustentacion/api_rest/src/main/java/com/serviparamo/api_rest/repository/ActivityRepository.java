package com.serviparamo.api_rest.repository;

import com.serviparamo.api_rest.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;



@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {
    ActivityEntity findByActivityName(String activityName);
}

/*
@Repository
public interface ActivityRepository extends
        JpaRepository<ActivityEntity, Long>,
        JpaSpecificationExecutor<ActivityEntity> {

    ActivityEntity findByActivityName(String activityName);

}
*/