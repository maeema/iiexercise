package com.example.iiexercise.services;

import com.example.iiexercise.entities.Author;

public interface IAuthorService {

	public Author add(Author author);

	public void update(Author author);

	public void delete(Long id);

}
