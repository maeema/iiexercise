package com.example.iiexercise.services;

import java.util.List;

import com.example.iiexercise.entities.Book;

import com.example.iiexercise.entities.Magazine;
import com.example.iiexercise.entities.Novel;
import com.example.iiexercise.exceptions.RunTimeRestControllerException;

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
