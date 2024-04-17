package com.akd.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.akd.library.entity.Library;
import com.akd.library.repo.LibraryRepo;

@Service
public class LibraryServiceImlp implements LibraryService {

	@Autowired
	private LibraryRepo libraryRepo;

	@Override
	public List<Library> getAllLibraries() {

		List<Library> list = new ArrayList<Library>();
		list = libraryRepo.findAll();
		return list;

	}

	@Override
	public List<Library> getLibrariesByLatestAddedOrder() {

		return libraryRepo.findAll(Sort.by(Direction.DESC, "id"));

	}

	@Override
	public List<Library> getLibrariesCustomSortedById(String sort) {

		System.out.println("Sort Value -> " + sort);
		Direction direction;
		if (sort.equalsIgnoreCase("desc")) {
			direction = Direction.DESC;

		} else {
			direction = Direction.ASC;
		}
		System.out.println("Direction -> " + direction);
		return libraryRepo.findAll(Sort.by(direction, "id"));
	}

	@Override
	public List<Library> getLibrariesCustomSortedByName(String sort) {

		System.out.println("Sort Value -> " + sort);
		Direction direction;
		if (sort.equalsIgnoreCase("desc")) {
			direction = Direction.DESC;

		} else {
			direction = Direction.ASC;
		}
		System.out.println("Direction -> " + direction);
		return libraryRepo.findAll(Sort.by(direction, "libraryName"));
	}

	@Override
	public List<Library> getLibrariesPaged(int pageNumber) {

		if (pageNumber <= 0) {
			pageNumber = 1;
		}
		int pageSize = 3;
		Pageable pageable = (Pageable) PageRequest.of(pageNumber - 1, pageSize); // page index starts from 0

		Page<Library> page = libraryRepo.findAll(pageable);
		return page.get().collect(Collectors.toList());
	}

	@Override
	public List<Library> getLibrariesPagedAndSortedByName(int pageNumber) {

		int pageSize = 2;

		Direction direction = Direction.ASC;
		Sort sort = Sort.by(direction, "libraryName");
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		Page<Library> page = libraryRepo.findAll(pageable);
		return page.get().collect(Collectors.toList());
	}

	@Override
	public List<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(int pageNumber, String bookName) {

		int pageSize = 2;

		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setBooks(bookName);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("books", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "libraryName");

		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);

		Direction direction = Direction.ASC;
		Sort sort = Sort.by(direction, "libraryName");
		Pageable pageable = (Pageable) PageRequest.of(pageNumber, pageSize, sort);
		Page<Library> page = libraryRepo.findAll(example, pageable);

		return page.get().collect(Collectors.toList());

	}

	@Override
	public List<Library> getSortedByNameAndWithTheseBooks(String bookName) {

		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setBooks(bookName);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("books", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "libraryName");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);

		Direction direction = Direction.ASC;
		Sort sort = Sort.by(direction, "libraryName");
		return libraryRepo.findAll(example, sort);

	}

	@Override
	public List<Library> getLibrariesByIds(List<Long> ids) {

		return libraryRepo.findAllById(ids);
	}

	@Override
	public Optional<Library> searchLibraryById(long id) {

		Optional<Library> optionalLibrary = libraryRepo.findById(id);

		return optionalLibrary;

	}

	@Override
	public Optional<Library> getALibraryWithTheseBooks(String bookName) {

		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setBooks(bookName);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("books", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "libraryName");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		return libraryRepo.findOne(example);

	}

	@Override
	public Library createSingleLibrary(Library library) {

		return libraryRepo.saveAndFlush(library);

	}

	@Override
	public List<Library> getAllLibrariesWithNoBooks() {
		Library libraryWithNoBooks = new Library();
		libraryWithNoBooks.setBooks("");

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("books", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "libraryName");

		Example<Library> example = Example.of(libraryWithNoBooks, exampleMatcher);

		return libraryRepo.findAll(example);

	}

}
