package com.olmez.fan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.olmez.fan.model.BaseObject;

@NoRepositoryBean
public interface BaseObjectRepository<T extends BaseObject> extends JpaRepository<T, Long> {

    @Override
    @Query("SELECT t FROM #{#entityName} t WHERE t.deleted = false")
    List<T> findAll();

    @Query("SELECT COUNT(t) FROM #{#entityName} t WHERE t.deleted = false")
    long countAll();

}
