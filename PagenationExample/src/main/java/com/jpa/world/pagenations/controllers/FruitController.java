package com.jpa.world.pagenations.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.world.pagenations.entities.Fruit;
import com.jpa.world.pagenations.services.FruitService;

@RestController
@RequestMapping("/api/fruits")
public class FruitController {

	@Autowired
	private FruitService service;

	@PostMapping("/save")
	public String saveFruit(@Valid @RequestBody Fruit fruit) {
		service.createFruit(fruit);

		return "Successfully saved with id" + fruit.getId();
	}

	@GetMapping
	public List<Fruit> list() {
		return service.list();
	}

	@GetMapping("/byprice/{price}")
	public List<Fruit> listByPrice(@PathVariable("price") double price, @RequestParam("page") int page,
			@RequestParam("size") int size) {
		return service.listByPrice(price, PageRequest.of(page, size, Direction.DESC, "price"));
	}

}
