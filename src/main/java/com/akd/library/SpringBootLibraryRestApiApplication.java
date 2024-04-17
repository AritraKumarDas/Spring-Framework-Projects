package com.akd.library;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.akd.library.entity.Library;
import com.akd.library.service.LibraryCreateService;
import com.akd.library.service.LibraryReadService;

@SpringBootApplication(scanBasePackages = "com.akd.library")
public class SpringBootLibraryRestApiApplication implements CommandLineRunner {

	@Autowired
	LibraryReadService libraryService;

	@Autowired
	LibraryCreateService libraryCreateService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryRestApiApplication.class, args);
		System.out.println("hi");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		Page<Library> page = libraryService.getLibrariesPaged();
//		List<Library> libraries = page.get().collect(Collectors.toList());
//		System.out.println(libraries);
//		System.out.println(libraryService.getLibrariesByLatestAddedOrder());
//		System.out.println(libraryService.getLibrariesCustomSortedById("desc"));
//		System.out.println(libraryService.getLibrariesCustomSortedByName("desc"));
//		System.out.println(libraryService.getLibrariesPagedAndSortedByName(0));
//		System.out.println(libraryService.getLibrariesPagedAndSortedByNameAndWithTheseBooks(0, "Rich dad Poor dad"));
//		System.out.println(libraryService.getSortedByNameAndWithTheseBooks("War and Peace"));

//		List<Long> ids = new ArrayList<Long>(Arrays.asList(5L, 7L));
//		System.out.println(libraOptionale.getLibrariesByIds(ids));

		/*
		 * try { Optional<Library> optionalLibrary =
		 * libraryService.getALibraryWithTheseBooks("War and Peace");
		 * 
		 * if (optionalLibrary.isPresent()) {
		 * System.out.println(libraryService.getALibraryWithTheseBooks("War and Peace").
		 * get()); Exception e; } else { System.out.println("No books matched"); } }
		 * catch (Exception e) { System.out.println("\nMore than one result obtained!");
		 * }
		 */

		/*
		 * Library newLibrary =
		 * Library.builder().id(15).libraryName("Washington Library").
		 * books("Merchant of Venice") .build(); Library returnedLibrary =
		 * libraryService.createSingleLibrary(newLibrary);
		 * System.out.println(returnedLibrary);
		 */

		List<Library> list = new ArrayList<Library>();
		list.add(new Library(18, "Calcutta National Library", "Swadhinota Hinotay"));
		list.add(new Library(19, "Central Iron Library", "Indian Independence Stuggle"));
		List<Library> addedList = libraryCreateService.addAllLibraries(list);
		System.out.println(addedList);

	}

}
