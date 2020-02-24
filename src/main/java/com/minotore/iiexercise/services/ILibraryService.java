package com.minotore.iiexercise.services;

import com.minotore.iiexercise.entities.Library;
import com.minotore.iiexercise.exceptions.RunTimeRestControllerException;

public interface ILibraryService {

	public Library getByName(String name) throws RunTimeRestControllerException;

	public Library add(Library library) throws RunTimeRestControllerException;

	public void update(Library library) throws RunTimeRestControllerException;

	public void delete(Long id) throws RunTimeRestControllerException;

}
