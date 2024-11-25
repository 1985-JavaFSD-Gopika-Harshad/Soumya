package com.fruit.seller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fruit.seller.model.Fruit;
import com.fruit.seller.repository.FruitRepository;

@Service
public class FruitService {
	
	@Autowired
	private FruitRepository fruitRepository;
	
	public FruitService(FruitRepository fruitRepository) {
		this.fruitRepository=fruitRepository;
	}
	
	//add fruits
	public Fruit addFruits(Fruit fruit) {
		return fruitRepository.save(fruit);
	}
	
	public Fruit getFruitById(Integer id) {
		return fruitRepository.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Fruit not found"));
	}
	
	public Fruit updateFruit(Integer id, Fruit fruit) {
		Fruit existingFruit = fruitRepository.findById(id)
				           .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fruit not found"));
		existingFruit.setName(fruit.getName());
		existingFruit.setQuantity(fruit.getQuantity());
		existingFruit.setPrice(fruit.getPrice());
		
		return fruitRepository.save(existingFruit);
	}

}
