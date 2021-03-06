package com.minotore.iiexercise.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minotore.iiexercise.entities.Library;

public interface LibraryRepository extends JpaRepository<Library, Long> {

	Library findOneByName(String name);

	boolean existsByName(String name);

}
