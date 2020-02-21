package com.example.iiexercise.services.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iiexercise.dao.BookRepository;
import com.example.iiexercise.dao.MagazineRepository;
import com.example.iiexercise.dao.NovelRepository;
import com.example.iiexercise.dao.StockRepository;
import com.example.iiexercise.entities.Book;
import com.example.iiexercise.entities.BookCategory;
import com.example.iiexercise.entities.Magazine;
import com.example.iiexercise.entities.Novel;
import com.example.iiexercise.entities.Stock;
import com.example.iiexercise.exceptions.RunTimeRestControllerException;
import com.example.iiexercise.services.IBookService;
import com.example.iiexercise.services.verificators.AuthorVerificators;
import com.example.iiexercise.services.verificators.BookVerificators;

@Service
public class BookService implements IBookService {

	@Autowired
	private BookVerificators bookVerificators;
	@Autowired
	private AuthorVerificators authorVerificators;

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private NovelRepository novelRepository;
	@Autowired
	private MagazineRepository magazineRepository;
	@Autowired
	private StockRepository stockRepository;

	@Override
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@Override
	public List<Book> getByLibraryName(String libraryName) throws RunTimeRestControllerException {
		List<Book> books = new ArrayList<>();
		List<Stock> stocks = stockRepository.findAllByLibraryName(libraryName);
		for (Stock stock : stocks) {
			books.add(stock.getBook());
		}
		return books;
	}

	@Override
	public Novel getNovelMostSoldedByAuthor(Long authorId) throws RunTimeRestControllerException {
		authorVerificators.verifyAuthorIdExist(authorId);
		return novelRepository.findTopByAuthorIdOrderByTotalUnitSoldDesc(authorId);
	}

	@Override
	public Magazine getMagazineClosedRelease(String category) throws RunTimeRestControllerException {
		bookVerificators.verifyBookCategoryExist(category);
		return magazineRepository
				.findTopByCategoryOrderByNextReleaseDateDesc(BookCategory.valueOf(category.toUpperCase()));
	}

	@Override
	public Novel addNovel(Novel novel) throws RunTimeRestControllerException {
		bookVerificators.verifyBookForInsertion(novel);
		if (novel.getTotalUnitSold() == null) {
			novel.setTotalUnitSold(0L);
		}

		novel.setId(null); // <^_^>
		return novelRepository.save(novel);
	}

	@Override
	public Magazine addMagazine(Magazine magazine) throws RunTimeRestControllerException {
		bookVerificators.verifyBookForInsertion(magazine);
		bookVerificators.verifyNextReleaseDate(magazine.getNextReleaseDate());
		if (magazine.getTotalUnitSold() == null) {
			magazine.setTotalUnitSold(0L);
		}
		magazine.setId(null); // <^_^>
		return magazineRepository.save(magazine);
	}

	@Override
	public void update(Book book) throws RunTimeRestControllerException {
		bookVerificators.verifyBookForUpdate(book);
		Optional<Magazine> bookIsMagazine = magazineRepository.findById(book.getId());
		if (bookIsMagazine.isPresent()) {
			magazineRepository.saveAndFlush(bookIsMagazine.get().setByBook(book));
		} else {
			Optional<Novel> bookIsNovel = novelRepository.findById(book.getId());
			novelRepository.saveAndFlush(bookIsNovel.get().setByBook(book));
		}
	}

	@Override
	public void delete(Long id) throws RunTimeRestControllerException {
		bookVerificators.verifyBookIdExist(id);
		bookRepository.deleteById(id);
	}

}
