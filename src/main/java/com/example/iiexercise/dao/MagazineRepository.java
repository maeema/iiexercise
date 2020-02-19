package com.example.iiexercise.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.iiexercise.entities.BookCategory;
import com.example.iiexercise.entities.Magazine;

public interface MagazineRepository extends JpaRepository<Magazine, Long>{

	Magazine findTopByCategoryOrderByNextReleaseDateDesc(BookCategory cooking);

}
