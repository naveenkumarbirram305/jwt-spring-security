package com.example.demo.ct.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.ct.abstractfactorydesign.Computer;
import com.example.demo.ct.abstractfactorydesign.ComputerFactory;
import com.example.demo.ct.abstractfactorydesign.PCFactory;
import com.example.demo.ct.abstractfactorydesign.ServerFactory;
import com.example.demo.ct.factorydesign.Shape;
import com.example.demo.ct.factorydesign.ShapeFactory;
import com.example.demo.ct.service.FactoryDesignService;

@Service
public class FactoryDesignServiceImpl implements FactoryDesignService {

	@Override
	public String factoryDesign(String shape) {
		ShapeFactory shapeFactory = new ShapeFactory();

		// get an object of Circle and call its draw method.
		Shape shape1 = shapeFactory.getShape(shape);

		// call draw method of Circle
		return shape1.draw();
	}

	@Override
	public String abstractDesign(String type) {
		Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB", "500 GB", "2.4 GHz"));
		Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB", "1 TB", "2.9 GHz"));
		System.out.println();
		System.out.println("AbstractFactory Server Config::" + server);
		return "AbstractFactory PC Config::" + pc;
	}

}
