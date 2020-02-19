package com.example.iiexercise.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.iiexercise.entities.Novel;

public interface NovelRepository extends JpaRepository<Novel, Long> {

	Novel findTopByAuthorIdOrderByTotalUnitSoldDesc(Long authorId);

}
