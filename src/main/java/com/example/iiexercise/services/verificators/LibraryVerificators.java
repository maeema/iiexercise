package com.example.iiexercise.services.verificators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.iiexercise.dao.LibraryRepository;
import com.example.iiexercise.entities.Library;
import com.example.iiexercise.exceptions.DataAlreadyExistException;
import com.example.iiexercise.exceptions.DataNotExistException;
import com.example.iiexercise.exceptions.MissingDataException;
import com.example.iiexercise.exceptions.RunTimeRestControllerException;

@Service
public class LibraryVerificators {
	@Autowired
	private LibraryRepository libraryRepository;

	public void verifyLibraryIdExist(Long libraryId) throws RunTimeRestControllerException {
		if (libraryId == null || !libraryRepository.existsById(libraryId))
			throw new DataNotExistException(" there is no library has id =" + libraryId);

	}

	public void verifyLibraryForInsertion(Library library) throws RunTimeRestControllerException {
		if (library == null || library.getName() == null || library.getAddress() == null) {
			throw new MissingDataException("Library must have name and address");
		}
		if (libraryRepository.existsByName(library.getName())) {
			throw new DataAlreadyExistException("Library with name " + library.getName(), "Libraries");
		}

	}

	public void verifyLibraryForUpdate(Library library) throws RunTimeRestControllerException {
		if (library == null || library.getId() == null) {
			throw new MissingDataException("Library must have id");
		}
		if (libraryRepository.existsByName(library.getName())) {
			throw new DataAlreadyExistException("Library with name " + library.getName(), "Libraries");
		}

	}

}
