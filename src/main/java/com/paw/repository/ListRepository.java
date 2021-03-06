package com.paw.repository;

import com.paw.entity.ListEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends CrudRepository<ListEntity, Long> {
}
