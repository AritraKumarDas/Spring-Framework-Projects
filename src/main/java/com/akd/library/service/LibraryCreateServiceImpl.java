package com.akd.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akd.library.entity.Library;
import com.akd.library.repo.LibraryRepo;

@Service
public class LibraryCreateServiceImpl implements LibraryCreateService {

	@Autowired
	LibraryRepo libraryRepo;

	public List<Library> addAllLibraries(List<Library> librariesList) {

		return libraryRepo.saveAllAndFlush(librariesList);
	}

}
