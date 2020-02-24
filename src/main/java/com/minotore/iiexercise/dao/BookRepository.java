package com.minotore.iiexercise.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minotore.iiexercise.entities.Book;
import com.minotore.iiexercise.entities.Stock;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	List<Book> findAllByStocksIn(List<Stock> booksByLibrary);

	boolean existsByName(String name);


}
