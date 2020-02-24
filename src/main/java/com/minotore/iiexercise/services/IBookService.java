package com.minotore.iiexercise.services;

import java.util.List;

import com.minotore.iiexercise.entities.Book;
import com.minotore.iiexercise.entities.Magazine;
import com.minotore.iiexercise.entities.Novel;

public interface IBookService {

	public List<Book> getAll();

	public List<Book> getByLibraryName(String libraryName);

	public Novel getNovelMostSoldedByAuthor(Long authorId);

	public Magazine getMagazineClosedRelease(String cathegorie);

	public Novel addNovel(Novel novel);

	public Magazine addMagazine(Magazine magazine);

	public void update(Book book);

	public void delete(Long id);

}
