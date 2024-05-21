package com.example.demo.ct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ct.service.FactoryDesignService;

@RestController
@RequestMapping("/api")
public class FactoryDesignController {

	private final FactoryDesignService factoryDesignService;

	@Autowired
	public FactoryDesignController(FactoryDesignService factoryDesignService) {
		this.factoryDesignService = factoryDesignService;
	}

	@GetMapping("/factory")
	public String checkShapeFactoryDesign(@RequestParam String shape) {
		return factoryDesignService.factoryDesign(shape);
	}
	
	@GetMapping("/abstractFactory")
	public String abstractDesignPattern(@RequestParam String type) {
		return factoryDesignService.abstractDesign(type);
	}
}
