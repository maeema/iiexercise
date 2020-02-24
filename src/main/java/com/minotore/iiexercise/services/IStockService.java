package com.minotore.iiexercise.services;

import java.util.List;

import com.minotore.iiexercise.entities.Stock;
import com.minotore.iiexercise.exceptions.RunTimeRestControllerException;

public interface IStockService {
	public List<Stock> getStocksByLibraryName(String libraryName) throws RunTimeRestControllerException;
	public Stock add(Stock stock) throws RunTimeRestControllerException;
}
