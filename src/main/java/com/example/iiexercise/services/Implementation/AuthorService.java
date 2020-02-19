package com.example.iiexercise.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iiexercise.dao.AuthorRepository;
import com.example.iiexercise.entities.Author;
import com.example.iiexercise.services.IAuthorService;
import com.example.iiexercise.services.verificators.AuthorVerificators;

@Service
public class AuthorService implements IAuthorService {

	@Autowired
	private AuthorVerificators authorVerificators;

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Author add(Author author) {
		authorVerificators.verifyAuthorForInsertion(author);
		// to assert the new author will be inserted in new line we need to set id null.
		// <^_^> I'm genius
		author.setId(null);
		return authorRepository.save(author);
	}

	@Override
	public void update(Author author) {
		authorVerificators.verifyAuthorForUpdate(author);
		authorVerificators.verifyUpdatedAuthorNotNull(author);
		authorRepository.saveAndFlush(author);
	}

	@Override
	public void delete(Long id) {
		authorVerificators.verifyAuthorIdExist(id);
		authorRepository.deleteById(id);

	}

}
