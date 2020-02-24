package com.minotore.iiexercise.services.verificators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minotore.iiexercise.dao.LibraryRepository;
import com.minotore.iiexercise.entities.Library;
import com.minotore.iiexercise.exceptions.DataAlreadyExistException;
import com.minotore.iiexercise.exceptions.DataNotExistException;
import com.minotore.iiexercise.exceptions.MissingDataException;

@Service
public class LibraryVerificators {
	@Autowired
	private LibraryRepository libraryRepository;

	public void verifyLibraryIdExist(Long libraryId) {
		if (libraryId == null || !libraryRepository.existsById(libraryId))
			throw new DataNotExistException(" there is no library has id =" + libraryId);

	}

	public void verifyLibraryForInsertion(Library library) {
		if (library == null || library.getName() == null || library.getAddress() == null) {
			throw new MissingDataException("Library must have name and address");
		}
		if (libraryRepository.existsByName(library.getName())) {
			throw new DataAlreadyExistException("Library with name " + library.getName(), "Libraries");
		}

	}

	public void verifyLibraryForUpdate(Library library) {
		if (library == null || library.getId() == null) {
			throw new MissingDataException("Library must have id");
		}
		if (libraryRepository.existsByName(library.getName())) {
			throw new DataAlreadyExistException("Library with name " + library.getName(), "Libraries");
		}

	}

}
