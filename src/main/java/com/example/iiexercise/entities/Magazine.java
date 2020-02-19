package com.example.iiexercise.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Magazine extends Book implements Serializable {
	/**
	 * Define Magazine
	 */

	private static final long serialVersionUID = -685201247901436470L;

	private Date nextReleaseDate;

	@ManyToMany
	private Set<KeySubject> keySubjects;

	public Magazine setByBook(Book book) {
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

	public Magazine() {
		super();
	}

	public Magazine(String name, Double price, Long totalUnitSold, BookCategory category, Date publicationDate,
			int numberOfPages, Author auther, Date nextReleaseDate) {
		super(name, price, totalUnitSold, category, publicationDate, numberOfPages, auther);
		this.nextReleaseDate = nextReleaseDate;

	}

	public Date getNextReleaseDate() {
		return nextReleaseDate;
	}

	public void setNextReleaseDate(Date nextReleaseDate) {
		this.nextReleaseDate = nextReleaseDate;
	}

	public Set<KeySubject> getKeySubjects() {
		return keySubjects;
	}

	public void setKeySubjects(Set<KeySubject> keySubjects) {
		this.keySubjects = keySubjects;
	}

	@Override
	public String toString() {
		return "Magasine [nextReleaseDate=" + nextReleaseDate + ", KeySubjects=" + keySubjects + "] extend of"
				+ super.toString();
	}

}
