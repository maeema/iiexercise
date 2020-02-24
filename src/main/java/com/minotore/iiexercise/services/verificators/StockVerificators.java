package com.minotore.iiexercise.services.verificators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minotore.iiexercise.dao.StockRepository;
import com.minotore.iiexercise.entities.Stock;
import com.minotore.iiexercise.exceptions.DataAlreadyExistException;
import com.minotore.iiexercise.exceptions.DataNotExistException;
import com.minotore.iiexercise.exceptions.MissingDataException;
import com.minotore.iiexercise.exceptions.WrongValueException;

@Service
public class StockVerificators {

	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private LibraryVerificators libraryVerificators;
	@Autowired
	private BookVerificators bookVerificators;

	public void verifyStockIdExist(Long stockId) {
		if (stockId == null || !stockRepository.existsById(stockId))
			throw new DataNotExistException(" there is no library has id =" + stockId);
	}

	public void verifyStockForInsertion(Stock stock) {
		if (stock == null || stock.getLibrary() == null || stock.getLibrary().getId() == null || stock.getBook() == null
				|| stock.getBook().getId() == null)
			throw new MissingDataException("To add book to library you must have object library and object with ids");
		if (stock.getQuantity() < 0)
			throw new WrongValueException("Quantity must be a positive number");
		libraryVerificators.verifyLibraryIdExist(stock.getLibrary().getId());
		bookVerificators.verifyBookIdExist(stock.getBook().getId());
		if (stockRepository.existsByLibraryIdAndBookId(stock.getLibrary().getId(), stock.getBook().getId()))
			throw new DataAlreadyExistException(
					"book already exists in this library");
	}

	public void verifyStockForUpdate(Stock stock) {
		if (stock == null || stock.getId() == null)
			throw new MissingDataException("You must add the stock id to modify it");
		if (stock.getQuantity() < 0)
			throw new WrongValueException("Quantity must be a positive number");
		if (stock.getLibrary() != null)
			libraryVerificators.verifyLibraryForUpdate(stock.getLibrary());
		if (stock.getBook() != null)
			bookVerificators.verifyBookForUpdate(stock.getBook());
		if (stockRepository.existsByLibraryIdAndBookId(stock.getLibrary().getId(), stock.getBook().getId()))
			throw new DataAlreadyExistException(
					"book already exists in this library");
		
	}

}
