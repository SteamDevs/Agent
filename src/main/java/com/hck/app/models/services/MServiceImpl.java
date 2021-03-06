package com.hck.app.models.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hck.app.models.dao.MetricsRepository;
import com.hck.app.models.entity.Metrics;

@Service
public class MServiceImpl implements MetricsService {
	
	@Autowired
	private MetricsRepository metricsDao; 
	
	@Override
	public List<Metrics> findAll() {
		return (List<Metrics>) metricsDao.findAll();
	}

	@Override
	public Metrics findByIdMetrics(Long id) {
		// TODO Auto-generated method stub
		return metricsDao.
				findById(id).orElse(null);
	}

	@Override
	public Metrics saveMetrics(Metrics metrics) {
		// TODO Auto-generated method stub
		return metricsDao.save(metrics);
	}

	@Override
	public void deleteMetric(Long id) {
		// TODO Auto-generated method stub
		metricsDao.deleteById(id);
	}
	
	

}
