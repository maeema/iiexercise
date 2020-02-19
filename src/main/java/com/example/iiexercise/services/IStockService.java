package com.example.iiexercise.services;

import java.util.List;

import com.example.iiexercise.entities.Stock;

public interface IStockService {
	public List<Stock> getStocksByLibraryName(String libraryName);
	public Stock add(Stock stock);
}
