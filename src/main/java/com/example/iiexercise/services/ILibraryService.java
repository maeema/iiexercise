package com.example.iiexercise.services;

import com.example.iiexercise.entities.Library;
import com.example.iiexercise.exceptions.RunTimeRestControllerException;

public interface ILibraryService {

	public Library getByName(String name) throws RunTimeRestControllerException;

	public Library add(Library library) throws RunTimeRestControllerException;

	public void update(Library library) throws RunTimeRestControllerException;

	public void delete(Long id) throws RunTimeRestControllerException;

}
