package com.example.iiexercise.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iiexercise.dao.LibraryRepository;
import com.example.iiexercise.entities.Library;
import com.example.iiexercise.exceptions.RunTimeRestControllerException;
import com.example.iiexercise.services.ILibraryService;
import com.example.iiexercise.services.verificators.LibraryVerificators;

@Service
public class LibraryService implements ILibraryService {
	@Autowired
	private LibraryRepository libraryRepository;
	@Autowired
	private LibraryVerificators libraryVerificators;

	@Override
	public Library getByName(String name) {
		return libraryRepository.findOneByName(name);
	}

	@Override
	public Library add(Library library) throws RunTimeRestControllerException {
		libraryVerificators.verifyLibraryForInsertion(library);
		library.setId(null); // <^_^>
		return libraryRepository.save(library);
	}

	public void update(Library library) throws RunTimeRestControllerException {
		libraryVerificators.verifyLibraryForUpdate(library);
		libraryRepository.saveAndFlush(library);
	}

	public void delete(Long id) throws RunTimeRestControllerException {
		libraryVerificators.verifyLibraryIdExist(id);
		libraryRepository.deleteById(id);
		
	}

}
