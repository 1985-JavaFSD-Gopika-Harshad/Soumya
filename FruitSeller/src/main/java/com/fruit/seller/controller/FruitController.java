package com.fruit.seller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fruit.seller.model.Fruit;
import com.fruit.seller.service.FruitService;

@RestController
@RequestMapping("/fruits")
public class FruitController {
	
	@Autowired
	private FruitService fruitService;
	
	public FruitController(FruitService fruitService) {
		this.fruitService= fruitService;
	}
	
	@PostMapping
	public ResponseEntity<Fruit> addFruits(@RequestBody Fruit fruit) {
		return new ResponseEntity<>(fruitService.addFruits(fruit), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Fruit> getFruitById(@PathVariable Integer id) {
		return new ResponseEntity<>(fruitService.getFruitById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Fruit> updateFruit(@PathVariable Integer id,@RequestBody Fruit fruit) {
		return new ResponseEntity<>(fruitService.updateFruit(id, fruit), HttpStatus.OK);
	}




}
