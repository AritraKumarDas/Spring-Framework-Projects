package com.akd.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akd.library.entity.Library;
import com.akd.library.service.LibraryReadService;

@RestController
public class LibraryController {

	@Autowired
	LibraryReadService libraryService;

//	@GetMapping("/libraries")
//	public List<Library> getLibraries() {
//		return libraryService.getAllLibraries();
//	}

	@GetMapping("/libraries/{id}")
	public Optional<Library> getLibraryById(@PathVariable Long id) {
		return libraryService.searchLibraryById(id);
	}

	@GetMapping("/libraries/page/{pageNum}")
	public List<Library> getLibrariesPaged(@PathVariable int pageNum) {
		return libraryService.getLibrariesPaged(pageNum);
	}

	@GetMapping("/libraries/revsort")
	public List<Library> getLibrariesWithLatestAddedOrder(/* @RequestParam(defaultValue = "desc") String direction */) {
		return libraryService.getLibrariesByLatestAddedOrder();
	}

	@GetMapping("/libraries")
	public List<Library> getLibrariesCustomSortedById(@RequestParam(defaultValue = "asc") String sort) {

		System.out.println("SORT = " + sort);
		return libraryService.getLibrariesCustomSortedById(sort);

	}

	@GetMapping("/empty-libraries")
	public List<Library> getLibrariesWithNoBooks() {
		return libraryService.getAllLibrariesWithNoBooks();
	}

	@PostMapping("/create-library")
	public Library saveLibrary(@RequestBody Library library) {
		return libraryService.createSingleLibrary(library);

	}

}
