package com.hck.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.hck.app.models.entity.Metrics;
  
public interface MetricsRepository extends CrudRepository<Metrics, Long > {

}
