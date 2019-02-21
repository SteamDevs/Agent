package com.hck.app.models.services;

import java.util.List;

import com.hck.app.models.entity.Metrics;

public interface MetricsService {
	
	
	public List<Metrics> findAll();
	
	public Metrics findByIdMetrics(Long id);
	
	public Metrics saveMetrics(Metrics metrics);
	
	public void deleteMetric(Long id);
}
