package com.akd.library.service;

import java.util.List;

import com.akd.library.entity.Library;

public interface LibraryDeleteService {

	String deleteOneLibrary(Library library);

	String deleteAllLibraries();

	String deleteAllTheseLibraries(List<Library> libraries);

	String deleteAllLibrariesInBatch();

	String deleteLibraryById(long id);

	String deleteTheseLibrariesInBatch(List<Library> libraries);

}