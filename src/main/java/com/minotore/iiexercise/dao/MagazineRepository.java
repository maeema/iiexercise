package com.minotore.iiexercise.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minotore.iiexercise.entities.BookCategory;
import com.minotore.iiexercise.entities.Magazine;

public interface MagazineRepository extends JpaRepository<Magazine, Long>{

	Magazine findTopByCategoryOrderByNextReleaseDateDesc(BookCategory cooking);

}
