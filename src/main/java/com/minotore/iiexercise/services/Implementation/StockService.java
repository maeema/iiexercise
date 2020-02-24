package com.minotore.iiexercise.services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minotore.iiexercise.dao.StockRepository;
import com.minotore.iiexercise.entities.Stock;
import com.minotore.iiexercise.services.IStockService;
import com.minotore.iiexercise.services.verificators.StockVerificators;

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
	public Stock add(Stock stock) {
		stockVerificators.verifyStockForInsertion(stock);
		return stockRepository.save(stock);
	}

	public void update(Stock stock) {
		stockVerificators.verifyStockForUpdate(stock);
		stockRepository.saveAndFlush(stock);

	}

	public void delete(Long id) {
		stockVerificators.verifyStockIdExist(id);
		stockRepository.deleteById(id);

	}

}
