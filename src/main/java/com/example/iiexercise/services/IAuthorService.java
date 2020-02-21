package com.example.iiexercise.services;

import com.example.iiexercise.entities.Author;
import com.example.iiexercise.exceptions.RunTimeRestControllerException;

public interface IAuthorService {

	public Author add(Author author) throws RunTimeRestControllerException;

	public void update(Author author) throws RunTimeRestControllerException;

	public void delete(Long id) throws RunTimeRestControllerException;

}
