package com.akd.library.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.akd.library.entity.Library;
import com.akd.library.repo.LibraryRepo;
import com.akd.library.service.LibraryCountService;

@Service
public class LibraryCountServiceImpl implements LibraryCountService {

	@Autowired
	LibraryRepo libraryRepo;

	@Override
	public long countLibraries() {

		return libraryRepo.count();
	}

	@Override
	public long countLibrariesWithZeroBooks() {
		Library libraryWithZeroBooks = new Library();
		libraryWithZeroBooks.setBooks("");
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("books", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "libraryName");
		Example<Library> example = Example.of(libraryWithZeroBooks, exampleMatcher);
		return libraryRepo.count(example);
	}

}
