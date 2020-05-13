package com.paw.repository;


import com.paw.entity.ArrayEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArrayRepository extends CrudRepository<ArrayEntity, Long> {

    List<ArrayEntity> findAll();
}
