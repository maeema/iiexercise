package com.example.iiexercise.services.verificators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iiexercise.dao.AuthorRepository;
import com.example.iiexercise.entities.Author;
import com.example.iiexercise.exceptions.DataAlreadyExistException;
import com.example.iiexercise.exceptions.DataNotExistException;
import com.example.iiexercise.exceptions.MissingDataException;
import com.example.iiexercise.exceptions.NullModificationException;
import com.example.iiexercise.exceptions.WrongValueException;

@Service
public class AuthorVerificators {

	@Autowired
	private AuthorRepository authorRepository;

	public void verifyAuthorIdExist(Long authorId) {
		if (authorId == null || !authorRepository.existsById(authorId))
			throw new DataNotExistException(" there is no book has id =" + authorId);
	}

	public void verifyUpdatedAuthorNotNull(Author author) {
		if (author.getName() == null && author.getAge() <= 0)
			throw new NullModificationException("There is no modification Author found ,we got" + author);
	}

	public void verifyAuthorForInsertion(Author author) {
		if (author == null || author.getName() == null || author.getAge() <= 0) {
			throw new MissingDataException("Author must have name and strictly positive age");
		}
		if (authorRepository.existsByNameAndAge(author.getName(), author.getAge())) {
			throw new DataAlreadyExistException(
					" The Author " + author.getName() + " with age = " + author.getAge() + " years", "Authors");
		}

	}

	public void verifyAuthorForUpdate(Author author) {
		if (author == null || author.getId() == null) {
			throw new MissingDataException("Author must have id");
		}
		if (author.getAge() == 0)
			author.setAge(authorRepository.findById(author.getId()).get().getAge());
		else if (author.getAge() < 0)
			throw new WrongValueException("Age can't be negative value [age = " + author.getAge() + "]");
		verifyAuthorIdExist(author.getId());
		if (author.getName() != null && author.getAge() > 0
				&& authorRepository.existsByNameAndAge(author.getName(), author.getAge())) {
			throw new DataAlreadyExistException(
					" The Author " + author.getName() + " with age = " + author.getAge() + " years", "Authors");
		}
	}
}
