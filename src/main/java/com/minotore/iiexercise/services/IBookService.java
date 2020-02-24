package com.minotore.iiexercise.services;

import java.util.List;

import com.minotore.iiexercise.entities.Book;
import com.minotore.iiexercise.entities.Magazine;
import com.minotore.iiexercise.entities.Novel;
import com.minotore.iiexercise.exceptions.RunTimeRestControllerException;

public interface IBookService {

	public List<Book> getAll() throws RunTimeRestControllerException;

	public List<Book> getByLibraryName(String libraryName) throws RunTimeRestControllerException;

	public Novel getNovelMostSoldedByAuthor(Long authorId) throws RunTimeRestControllerException;

	public Magazine getMagazineClosedRelease(String cathegorie) throws RunTimeRestControllerException;

	public Novel addNovel(Novel novel) throws RunTimeRestControllerException;

	public Magazine addMagazine(Magazine magazine) throws RunTimeRestControllerException;

	public void update(Book book) throws RunTimeRestControllerException;

	public void delete(Long id) throws RunTimeRestControllerException;

}
