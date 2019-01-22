package com.hck.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hck.app.models.entity.Metrics;
import com.hck.app.models.services.MServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class MetricsController {
	
	@Autowired
	private MServiceImpl metricsService;
	
	@GetMapping("/metrics")
	public List<Metrics> index(){
		return metricsService.findAll();
	}
}
