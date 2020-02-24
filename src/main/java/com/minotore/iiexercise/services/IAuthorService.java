package com.minotore.iiexercise.services;

import com.minotore.iiexercise.entities.Author;

public interface IAuthorService {

	public Author add(Author author);

	public void update(Author author);

	public void delete(Long id);

}
