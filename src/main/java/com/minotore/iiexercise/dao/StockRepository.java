package com.minotore.iiexercise.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minotore.iiexercise.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

	List<Stock> findAllByLibraryName(String libraryName);

	boolean existsByLibraryIdAndBookId(Long libraryId, Long bookId);

}
