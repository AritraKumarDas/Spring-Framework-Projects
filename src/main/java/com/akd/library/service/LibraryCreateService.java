package com.akd.library.service;

import java.util.List;

import com.akd.library.entity.Library;

public interface LibraryCreateService {

	public Library createSingleLibrary(Library library);

	public List<Library> addAllLibraries(List<Library> librariesList);

}
