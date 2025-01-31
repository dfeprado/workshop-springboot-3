package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> users = service.findAll();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable int id) {
		return ResponseEntity.ok(service.findById(id));
	}
}
