package com.minotore.iiexercise.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minotore.iiexercise.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	public Boolean existsByNameAndAge(String name, int age);

	public Author findByNameAndAge(String name, int age);
}
