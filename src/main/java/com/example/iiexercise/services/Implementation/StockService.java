package com.example.iiexercise.services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iiexercise.dao.StockRepository;
import com.example.iiexercise.entities.Stock;
import com.example.iiexercise.exceptions.RunTimeRestControllerException;
import com.example.iiexercise.services.IStockService;
import com.example.iiexercise.services.verificators.StockVerificators;

@Service
public class StockService implements IStockService {
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private StockVerificators stockVerificators;

	@Override
	public List<Stock> getStocksByLibraryName(String libraryName) {
		return stockRepository.findAllByLibraryName(libraryName);
	}

	@Override
	public Stock add(Stock stock) throws RunTimeRestControllerException {
		stockVerificators.verifyStockForInsertion(stock);
		return stockRepository.save(stock);
	}

	public void update(Stock stock) throws RunTimeRestControllerException {
		stockVerificators.verifyStockForUpdate(stock);
		stockRepository.saveAndFlush(stock);

	}

	public void delete(Long id) throws RunTimeRestControllerException {
		stockVerificators.verifyStockIdExist(id);
		stockRepository.deleteById(id);

	}

}
