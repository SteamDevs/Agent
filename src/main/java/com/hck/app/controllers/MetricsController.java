package com.hck.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hck.app.models.entity.Metrics;
import com.hck.app.models.services.MServiceImpl;

@CrossOrigin(origins = {"http://localhost:4200"}) //CorsConfig
@RestController
@RequestMapping("/api/v1")
public class MetricsController {
	
	@Autowired
	private MServiceImpl metricsService;
	
	@GetMapping("/metrics")
	public List<Metrics> index(){
		return metricsService.findAll();
	}
	
	
	//Saving metrics
	@PostMapping("/metrics")
	@ResponseStatus(HttpStatus.CREATED)
	public Metrics addMetrics(@RequestBody Metrics metrics  ) {
		return metricsService.saveMetrics(metrics);
	}
	
}
