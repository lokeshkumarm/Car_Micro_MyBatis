package com.newt.controller;

import java.util.List;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newt.dao.Impl.CarDAOImpl;
import com.newt.dao.model.Car;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	private static Logger log = LoggerFactory.getLogger(CarController.class);
	
	@Autowired
	private CarDAOImpl carDAO;
	
	@ApiOperation(value = "Find Car by Id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Car findById(@PathVariable String id){
		log.info("Find the Car matching the Id");
		log.error("lokloklok");
		log.debug("kumkumkum");
		try{
		Car result = carDAO.findById(id);
		return result;
		}
		catch (Exception e){
			log.error("Exception in CarController: findById" + e);
		}
		return null;
	}
	
	@ApiOperation(value = "Delete Car by Id")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable String id){
		log.info("Delete the Car matching the Id");
		
		try{
		carDAO.deleteById(id);
		
		}
		catch (Exception e){
			log.error("Exception in CarController: deleteById" + e);
		}
	}
	
}
