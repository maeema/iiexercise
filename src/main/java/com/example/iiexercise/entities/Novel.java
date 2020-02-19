package com.example.iiexercise.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Novel extends Book implements Serializable {
	/**
	 * Define Novel
	 */

	private static final long serialVersionUID = -687446197298552402L;

	@Column(columnDefinition = "TEXT")
	private String storySummary;

	public Novel setByBook(Book book) {
		setId(book.getId());
		if (book.getName() != null)
			setName(book.getName());
		if (book.getPrice() != null)
			setPrice(book.getPrice());
		if (book.getTotalUnitSold() != null)
			setTotalUnitSold(book.getTotalUnitSold());
		if (book.getCategory() != null)
			setCategory(book.getCategory());
		if (book.getPublicationDate() != null)
			setPublicationDate(book.getPublicationDate());
		if (book.getNumberOfPages() != null)
			setNumberOfPages(book.getNumberOfPages());
		if (book.getAuthor() != null)
			setAuthor(book.getAuthor());
		return this;
	}

	public Novel() {
		super();
	}

	public Novel(String name, Double price, Long totalUnitSold, BookCategory category, Date publicationDate,
			int numberOfPages, Author auther, String storySummary) {
		super(name, price, totalUnitSold, category, publicationDate, numberOfPages, auther);
		this.storySummary = storySummary;
	}

	public String getStorySummary() {
		return storySummary;
	}

	public void setStorySummary(String storySummary) {
		this.storySummary = storySummary;
	}

	@Override
	public String toString() {
		return "Novel [storySummary=" + storySummary + "] extend of " + super.toString();
	}

}
