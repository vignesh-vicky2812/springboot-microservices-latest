package com.rabbitmq.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.springboot.dto.User;
import com.rabbitmq.springboot.publisher.RabbitMQJsonProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

	private RabbitMQJsonProducer rabbitMQJsonProducer;

	public MessageJsonController(RabbitMQJsonProducer rabbitMQJsonProducer) {
		this.rabbitMQJsonProducer = rabbitMQJsonProducer;
	}
	@PostMapping("/publish")
	public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
		rabbitMQJsonProducer.sendJsonMessage(user);
		return ResponseEntity.ok("Json message sent to rabbitmq");
	}
}
