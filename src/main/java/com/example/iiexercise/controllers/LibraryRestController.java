package com.example.iiexercise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.iiexercise.entities.Library;
import com.example.iiexercise.entities.Stock;
import com.example.iiexercise.exceptions.RunTimeRestControllerException;
import com.example.iiexercise.services.Implementation.LibraryService;
import com.example.iiexercise.services.Implementation.StockService;

@RestController
public class LibraryRestController {
	@Autowired
	private LibraryService libraryService;
	@Autowired
	private StockService stockService;

	@GetMapping(path = "/library/stocks/{libname}")
	public ResponseEntity<?> getByLibrary(@PathVariable("libname") String libraryName) {
		try {
			return ResponseEntity.ok(stockService.getStocksByLibraryName(libraryName));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error found");
		}
	}

	@PostMapping(path = "/library/add")
	public ResponseEntity<?> addLibrary(@RequestBody Library library) {
		try {
			return ResponseEntity.ok(libraryService.add(library));
		} catch (RunTimeRestControllerException e) {
			return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error found");
		}
	}

	@PutMapping(path = "/library/update")
	public ResponseEntity<?> updateLibrary(@RequestBody Library library) {
		try {
			libraryService.update(library);
			return ResponseEntity.ok(null);
		} catch (RunTimeRestControllerException e) {
			return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error found");
		}
	}

	@DeleteMapping(path = "/library/delete/{id}")
	public ResponseEntity<?> deleteLibrary(@PathVariable("id") Long id) {
		try {
			libraryService.delete(id);
			return ResponseEntity.ok(null);
		} catch (RunTimeRestControllerException e) {
			return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error found");
		}
	}

	@PostMapping(path = "/library/addbook")
	public ResponseEntity<?> addStock(@RequestBody Stock stock) {
		try {
			return ResponseEntity.ok(stockService.add(stock));
		} catch (RunTimeRestControllerException e) {
			return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error found");
		}
	}

	@PutMapping(path = "/library/modifyBookQuantity")
	public ResponseEntity<?> updateStock(@RequestBody Stock stock) {
		try {
			stockService.update(stock);
			return ResponseEntity.ok(null);
		} catch (RunTimeRestControllerException e) {
			return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error found");
		}
	}

	@DeleteMapping(path = "/library/deleteBookFromLibrary/{id}")
	public ResponseEntity<?> deleteStock(@PathVariable("id") Long id) {
		try {
			stockService.delete(id);
			return ResponseEntity.ok(null);
		} catch (RunTimeRestControllerException e) {
			return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error found");
		}
	}
}
