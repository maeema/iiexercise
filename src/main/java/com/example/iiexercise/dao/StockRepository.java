package com.example.iiexercise.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.iiexercise.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{

	List<Stock> findAllByLibraryName(String libraryName);

}
