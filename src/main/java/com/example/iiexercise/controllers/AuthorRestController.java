package com.example.iiexercise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.iiexercise.entities.Author;
import com.example.iiexercise.exceptions.RunTimeRestControllerException;
import com.example.iiexercise.services.Implementation.AuthorService;

@RestController
public class AuthorRestController {
	@Autowired
	private AuthorService authorService;

	@PostMapping(path = "/author/add")
	public ResponseEntity<?> add(@RequestBody Author author) {
		try {
			return ResponseEntity.ok(authorService.add(author));
		} catch (RunTimeRestControllerException e) {
			return ResponseEntity.status(e.errorCode).body(e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error found");
		}
	}

	@PutMapping(path = "/author/update")
	public ResponseEntity<?> update(@RequestBody Author author) {
		try {
			authorService.update(author);
			return ResponseEntity.ok(null);
		} catch (RunTimeRestControllerException e) {
			return ResponseEntity.status(e.errorCode).body(e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error found");
		}

	}

	@DeleteMapping(path = "/author/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		try {
			authorService.delete(id);
			return ResponseEntity.ok(null);
		} catch (RunTimeRestControllerException e) {
			return ResponseEntity.status(e.errorCode).body(e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error found");
		}
	}
}
