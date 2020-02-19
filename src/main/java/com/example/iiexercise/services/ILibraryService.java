package com.example.iiexercise.services;

import com.example.iiexercise.entities.Library;

public interface ILibraryService {
	public Library getByName(String name);

	public Library add(Library library);

}
