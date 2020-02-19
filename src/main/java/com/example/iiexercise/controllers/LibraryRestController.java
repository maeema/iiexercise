package com.example.iiexercise.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.iiexercise.entities.Library;
import com.example.iiexercise.entities.Stock;
import com.example.iiexercise.services.Implementation.LibraryService;
import com.example.iiexercise.services.Implementation.StockService;

@RestController
public class LibraryRestController {
	@Autowired
	private LibraryService libraryService;
	@Autowired
	private StockService stockService;
	
	@GetMapping(path = "/library/stocks/{libname}")
	public List<Stock> getByLibrary(@PathVariable("libname") String libraryName) {
		return stockService.getStocksByLibraryName(libraryName);
	}
	
	@PostMapping(path = "/library/add")
	public Library addLibrary(@RequestBody Library library) {
		return libraryService.add(library);
	}
	
	@PutMapping(path="/library/update")
	public void updateLibrary(@RequestBody Library library) {
		libraryService.update(library);
	}
	
	@DeleteMapping(path = "/library/delete/{id}")
	public void deleteLibrary(@PathVariable("id") Long id) {
		libraryService.delete(id);
	}
	
	@PostMapping(path = "/library/addbook")
	public Stock addStock(@RequestBody Stock stock) {
		return stockService.add(stock);
	}
	
	@PutMapping(path = "/library/modifyBookQuantity")
	public void updateStock(@RequestBody Stock stock) {
		stockService.update(stock);
	}
	
	@DeleteMapping(path = "/library/deleteBookFromLibrary/{id}")
	public void deleteStock(@PathVariable("id") Long id) {
		stockService.delete(id);
	}
}
