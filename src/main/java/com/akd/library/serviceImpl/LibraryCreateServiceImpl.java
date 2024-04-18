package com.akd.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akd.library.entity.Library;
import com.akd.library.repo.LibraryRepo;
import com.akd.library.service.LibraryCreateService;

@Service
public class LibraryCreateServiceImpl implements LibraryCreateService {

	@Autowired
	LibraryRepo libraryRepo;

	public List<Library> addAllLibraries(List<Library> librariesList) {

		return libraryRepo.saveAllAndFlush(librariesList);
	}

	@Override
	public Library createSingleLibrary(Library library) {
		return libraryRepo.saveAndFlush(library);
	}

}
