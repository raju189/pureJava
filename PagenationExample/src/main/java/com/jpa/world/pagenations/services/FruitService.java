package com.jpa.world.pagenations.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jpa.world.pagenations.entities.Fruit;
import com.jpa.world.pagenations.repos.FruitRepository;

@Service
public class FruitService {

	@Autowired
	private FruitRepository repo;

	public void createFruit(Fruit fruit) {
		repo.save(fruit);
	}

	public List<Fruit> list() {
		return repo.findAll();
	}

	public List<Fruit> listByPrice(double price, PageRequest pageRequest) {
		return repo.findByPrice(price, pageRequest);
	}

}
