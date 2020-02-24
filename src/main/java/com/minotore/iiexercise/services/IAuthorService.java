package com.minotore.iiexercise.services;

import com.minotore.iiexercise.entities.Author;
import com.minotore.iiexercise.exceptions.RunTimeRestControllerException;

public interface IAuthorService {

	public Author add(Author author) throws RunTimeRestControllerException;

	public void update(Author author) throws RunTimeRestControllerException;

	public void delete(Long id) throws RunTimeRestControllerException;

}
