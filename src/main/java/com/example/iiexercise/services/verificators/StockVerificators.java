package com.example.iiexercise.services.verificators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iiexercise.dao.StockRepository;
import com.example.iiexercise.entities.Stock;
import com.example.iiexercise.exceptions.DataNotExistException;

@Service
public class StockVerificators {
	
	@Autowired
	private StockRepository stockRepository;

	public void verifyStockIdExist(Long stockId) {
		if (stockId == null || !stockRepository.existsById(stockId))
			throw new DataNotExistException(" there is no library has id =" + stockId);
	}

	public void verifyStockForInsertion(Stock stock) {
		// TODO Auto-generated method stub

	}

	public void verifyStockForUpdate(Stock stock) {
		// TODO Auto-generated method stub

	}

}
