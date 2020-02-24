package com.minotore.iiexercise.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minotore.iiexercise.dao.LibraryRepository;
import com.minotore.iiexercise.entities.Library;
import com.minotore.iiexercise.exceptions.RunTimeRestControllerException;
import com.minotore.iiexercise.services.ILibraryService;
import com.minotore.iiexercise.services.verificators.LibraryVerificators;

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
