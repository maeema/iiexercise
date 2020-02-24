package com.minotore.iiexercise.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Book implements Serializable {
	/**
	 * Define Book
	 */
	
	private static final long serialVersionUID = -3683216987907024122L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Double price;
	private Long totalUnitSold;

	@Enumerated(EnumType.STRING)
	private BookCategory category;
	private Date publicationDate;
	private Integer numberOfPages;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
	private List<Stock> stocks;

	@ManyToOne
	private Author author;

	public Book() {
		super();
	}

	public Book(String name, Double price, Long totalUnitSold, BookCategory category, Date publicationDate,
			int numberOfPages, Author auther) {
		super();
		this.name = name;
		this.price = price;
		this.totalUnitSold = totalUnitSold;
		this.category = category;
		this.publicationDate = publicationDate;
		this.numberOfPages = numberOfPages;
		this.author = auther;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getTotalUnitSold() {
		return totalUnitSold;
	}

	public void setTotalUnitSold(Long totalUnitSold) {
		this.totalUnitSold = totalUnitSold;
	}

	public BookCategory getCategory() {
		return category;
	}

	public void setCategory(BookCategory category) {
		this.category = category;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Integer getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((numberOfPages == null) ? 0 : numberOfPages.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberOfPages == null) {
			if (other.numberOfPages != null)
				return false;
		} else if (!numberOfPages.equals(other.numberOfPages))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", totalUnitSold=" + totalUnitSold
				+ ", category=" + category + ", publicationDate=" + publicationDate + ", numberOfPages=" + numberOfPages
				+ ", author=" + author + "]";
	}

}
