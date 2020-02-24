package com.minotore.iiexercise.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minotore.iiexercise.dao.AuthorRepository;
import com.minotore.iiexercise.entities.Author;
import com.minotore.iiexercise.exceptions.RunTimeRestControllerException;
import com.minotore.iiexercise.services.IAuthorService;
import com.minotore.iiexercise.services.verificators.AuthorVerificators;

@Service
public class AuthorService implements IAuthorService {

	@Autowired
	private AuthorVerificators authorVerificators;

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Author add(Author author) throws RunTimeRestControllerException{
		authorVerificators.verifyAuthorForInsertion(author);
		// to assert the new author will be inserted in new line we need to set id null.
		// <^_^> I'm genius
		author.setId(null);
		return authorRepository.save(author);
	}

	@Override
	public void update(Author author) throws RunTimeRestControllerException {
		authorVerificators.verifyAuthorForUpdate(author);
		authorVerificators.verifyUpdatedAuthorNotNull(author);
		authorRepository.saveAndFlush(author);
	}

	@Override
	public void delete(Long id) throws RunTimeRestControllerException {
		authorVerificators.verifyAuthorIdExist(id);
		authorRepository.deleteById(id);

	}

}
