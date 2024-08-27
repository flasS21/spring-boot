package com.code4fun.app.controller;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code4fun.app.dao.Controller;
import com.code4fun.app.dto.UserRequest;
import com.code4fun.app.entity.User;
import com.code4fun.app.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController implements Controller<UserRequest> {

	private final UserService userService;

	@Override
	@PostMapping("/create")
	public ResponseEntity<?> create(UserRequest userRequest) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(userService.create(userRequest));
	}

	@Override
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieveById(Long id) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.retrieveById(id));
	}

	@Override
	@GetMapping("/retrieveAll")
	public ResponseEntity<Set<User>> retrieveAll() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.retrieveAll());
	}

	@Override
	@PatchMapping("/update/{id}")
	public ResponseEntity<?> update(Long id, UserRequest userRequest) {
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(userService.update(id, userRequest));
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(Long id) {
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(userService.delete(id));
	}

}
