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

import com.example.iiexercise.entities.Book;
import com.example.iiexercise.entities.Magazine;
import com.example.iiexercise.entities.Novel;
import com.example.iiexercise.exceptions.RunTimeRestControllerException;
import com.example.iiexercise.services.Implementation.BookService;

@RestController
public class BookRestController {

	@Autowired
	private BookService bookService;

	@GetMapping(path = "/books/all")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.ok(bookService.getAll());
		} catch (RunTimeRestControllerException e) {
			return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error found");
		}
	}

	@GetMapping(path = "/books/inlib/{libname}")
	public ResponseEntity<?> getByLibrary(@PathVariable("libname") String libraryName) {
		try {
			return ResponseEntity.ok(bookService.getByLibraryName(libraryName));
		} catch (RunTimeRestControllerException e) {
			return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error found");
		}
	}

	@GetMapping(path = "/novel/byauthor/{id}/most-sold")
	public ResponseEntity<?> getNovelMostSoldedByAuthor(@PathVariable("id") Long authorId) {
		try {
			return ResponseEntity.ok(bookService.getNovelMostSoldedByAuthor(authorId));
		} catch (RunTimeRestControllerException e) {
			return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error found");
		}
	}

	@GetMapping(path = "/magazine/{cathegorie}/closed-release")
	public ResponseEntity<?> getMagazineClosedReleaseByCathegorie(@PathVariable("cathegorie") String cathegorie) {
		try {
			return ResponseEntity.ok(bookService.getMagazineClosedRelease(cathegorie));
		} catch (RunTimeRestControllerException e) {
			return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error found");
		}
	}

	@PostMapping(path = "/novel/add")
	public ResponseEntity<?> addNovel(@RequestBody Novel novel) {
		try {
			return ResponseEntity.ok(bookService.addNovel(novel));
		} catch (RunTimeRestControllerException e) {
			return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error found");
		}
	}

	@PostMapping(path = "/magazine/add")
	public ResponseEntity<?> addMagazine(@RequestBody Magazine magazine) {
		try {
			return ResponseEntity.ok(bookService.addMagazine(magazine));
		} catch (RunTimeRestControllerException e) {
			return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error found");
		}
	}

	@PutMapping(path = "/book/update")
	public ResponseEntity<?> updateBook(@RequestBody Book book) {
		try {
			bookService.update(book);
			return ResponseEntity.ok(null);
		} catch (RunTimeRestControllerException e) {
			return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error found");
		}
	}

	@DeleteMapping(path = "/book/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
		try {
			bookService.delete(id);
			return ResponseEntity.ok(null);
		} catch (RunTimeRestControllerException e) {
			return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unexpected error found");
		}
	}
}
