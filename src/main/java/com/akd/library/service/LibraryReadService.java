package com.akd.library.service;

import java.util.List;
import java.util.Optional;

import com.akd.library.entity.Library;

public interface LibraryReadService {

	public List<Library> getAllLibraries();

	public List<Library> getAllLibrariesWithNoBooks();

	public Optional<Library> searchLibraryById(long id);

	public List<Library> getLibrariesPaged(int pageNumber);

	public List<Library> getLibrariesByLatestAddedOrder();

	public List<Library> getLibrariesCustomSortedById(String sort);

	public List<Library> getLibrariesCustomSortedByName(String sort);

	public List<Library> getLibrariesPagedAndSortedByName(int pageNumber);

	public List<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(int pageNumber, String bookName);

	public List<Library> getSortedByNameAndWithTheseBooks(String bookName);

	public List<Library> getLibrariesByIds(List<Long> ids);

	public Optional<Library> getALibraryWithTheseBooks(String bookName);

	public Library createSingleLibrary(Library library);

}
