package com.example.iiexercise.services.verificators;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iiexercise.dao.BookRepository;
import com.example.iiexercise.entities.Book;
import com.example.iiexercise.entities.BookCategory;
import com.example.iiexercise.exceptions.DataAlreadyExistException;
import com.example.iiexercise.exceptions.DataNotExistException;
import com.example.iiexercise.exceptions.MissingDataException;
import com.example.iiexercise.exceptions.WrongValueException;

@Service
public class BookVerificators {

	@Autowired
	private AuthorVerificators authorVerificators;

	@Autowired
	private BookRepository bookRepository;

	public void verifyBookIdExist(Long bookId) {
		if (bookId == null || !bookRepository.existsById(bookId))
			throw new DataNotExistException(" there is no book has id =" + bookId);
	}

	public void verifyNextReleaseDate(Date nextReleaseDate) {
		if (nextReleaseDate.before(new Date())) {
			throw new WrongValueException("NextReleaseDate must be in the future");
		}
	}

	public void verifyBookCategoryExist(String categoryName) {
		for (BookCategory category : BookCategory.values()) {
			if (category.name().equalsIgnoreCase(categoryName)) {
				return;
			}
		}
		throw new MissingDataException("there is no category named " + categoryName);
	}

	public void verifyBookForInsertion(Book book) {
		if (book == null || book.getName() == null || book.getPrice() == null || book.getPublicationDate() == null
				|| book.getNumberOfPages() == null || book.getAuthor() == null)
			throw new MissingDataException(
					"Book must have name and positive price and publicationDate from past and strictly positive numberOfPages and object author that have id");
		if (book.getPrice() < 0)
			throw new WrongValueException("price must be positive value");
		if (book.getPublicationDate().after(new Date()))
			throw new WrongValueException("publicationDate must be from past");
		if (book.getNumberOfPages() <= 0)
			throw new WrongValueException("numberOfPages must be strictly positive");
		if (book.getAuthor().getId() == null)
			throw new WrongValueException("author must have id");
		if (bookRepository.existsByName(book.getName()))
			throw new DataAlreadyExistException("Book with name " + book.getName(), book.getClass().getSimpleName());
		authorVerificators.verifyAuthorIdExist(book.getAuthor().getId());
	}

	public void verifyBookForUpdate(Book book) {
		if (book == null || book.getId() == null)
			throw new MissingDataException(
					"Book must have id and name or positive price or publicationDate from past or strictly positive numberOfPages or object author that have id");
		if (book.getPrice() != null && book.getPrice() < 0)
			throw new WrongValueException("price must be a positive value");
		if (book.getPublicationDate() != null && book.getPublicationDate().after(new Date()))
			throw new WrongValueException("publicationDate must be from past");
		if (book.getNumberOfPages() != null && book.getNumberOfPages() <= 0)
			throw new WrongValueException("numberOfPages must be strictly positive");
		if (book.getAuthor() != null) {
			authorVerificators.verifyAuthorForUpdate(book.getAuthor());
		}
		if (book.getTotalUnitSold() != null && book.getTotalUnitSold() < 0) {
			throw new WrongValueException("totalUnitSold must be a positive value");
		}
		if (book.getName() != null && bookRepository.existsByName(book.getName()))
			throw new DataAlreadyExistException("Book with name " + book.getName(), book.getClass().getSimpleName());
		verifyBookIdExist(book.getId());
	}
}
