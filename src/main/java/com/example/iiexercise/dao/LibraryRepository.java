package com.example.iiexercise.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.iiexercise.entities.Library;

public interface LibraryRepository extends JpaRepository<Library, Long> {

	Library findOneByName(String name);

}
