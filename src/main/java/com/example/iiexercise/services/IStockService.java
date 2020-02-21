package com.example.iiexercise.services;

import java.util.List;

import com.example.iiexercise.entities.Stock;
import com.example.iiexercise.exceptions.RunTimeRestControllerException;

public interface IStockService {
	public List<Stock> getStocksByLibraryName(String libraryName) throws RunTimeRestControllerException;
	public Stock add(Stock stock) throws RunTimeRestControllerException;
}
