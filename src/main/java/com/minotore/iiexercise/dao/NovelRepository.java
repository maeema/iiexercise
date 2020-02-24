package com.minotore.iiexercise.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minotore.iiexercise.entities.Novel;

public interface NovelRepository extends JpaRepository<Novel, Long> {

	Novel findTopByAuthorIdOrderByTotalUnitSoldDesc(Long authorId);

}
