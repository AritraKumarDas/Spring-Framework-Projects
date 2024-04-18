package com.akd.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akd.library.entity.Library;
import com.akd.library.repo.LibraryRepo;
import com.akd.library.service.LibraryDeleteService;

@Service
public class LibraryDeleteServiceImpl implements LibraryDeleteService {

	@Autowired
	LibraryRepo libraryRepo;

	@Override
	public String deleteOneLibrary(Library library) {
		libraryRepo.delete(library);
		return "One library deleted" + library;
	}

	@Override
	public String deleteAllLibraries() {
		libraryRepo.deleteAll();
		return "All libraries deleted";
	}

	@Override
	public String deleteAllTheseLibraries(List<Library> libraries) {
		libraryRepo.deleteAll(libraries);
		return "All libraries in the list deleted";
	}

	@Override
	public String deleteAllLibrariesInBatch() {
		libraryRepo.deleteAllInBatch();
		return "All libraries in the list deleted in batch";
	}

	@Override
	public String deleteLibraryById(long id) {
		libraryRepo.deleteById(id);
		return String.format("Library with id=%d deleted", id);
	}

	@Override
	public String deleteTheseLibrariesInBatch(List<Library> libraries) {
		libraryRepo.deleteAllInBatch(libraries);
		return ("These Library deleted in batch mode");
	}
}
