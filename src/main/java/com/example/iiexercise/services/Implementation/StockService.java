package com.example.iiexercise.services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iiexercise.dao.StockRepository;
import com.example.iiexercise.entities.Stock;
import com.example.iiexercise.services.IStockService;

@Service
public class StockService implements IStockService {
	@Autowired
	StockRepository stockRepository;

	@Override
	public List<Stock> getStocksByLibraryName(String libraryName) {
		return stockRepository.findAllByLibraryName(libraryName);
	}

	@Override
	public Stock add(Stock stock) {
		return stockRepository.save(stock);
	}

	public void update(Stock stock) {
		stockRepository.saveAndFlush(stock);

	}

	public void delete(Long id) {
		stockRepository.deleteById(id);

	}

}
