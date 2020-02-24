package com.minotore.iiexercise.services;

import com.minotore.iiexercise.entities.Library;

public interface ILibraryService {

	public Library getByName(String name);

	public Library add(Library library);

	public void update(Library library);

	public void delete(Long id);

}
