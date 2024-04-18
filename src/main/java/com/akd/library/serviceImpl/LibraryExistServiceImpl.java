package com.akd.library.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.akd.library.entity.Library;
import com.akd.library.repo.LibraryRepo;
import com.akd.library.service.LibraryExistService;

@Service
public class LibraryExistServiceImpl implements LibraryExistService {

	@Autowired
	LibraryRepo libraryRepo;

	@Override
	public boolean checkLibraryExistsById(long id) {
		return libraryRepo.existsById(id);
	}

	@Override
	public boolean checkLibraryExistsByExample(String bookName) {
		Library libraryWithThisBooks = new Library();
		libraryWithThisBooks.setBooks(bookName);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("books", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "libraryName");
		Example<Library> example = Example.of(libraryWithThisBooks, exampleMatcher);
		return libraryRepo.exists(example);
	}

}
