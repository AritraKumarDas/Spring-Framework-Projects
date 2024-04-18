package com.akd.library;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.akd.library.entity.Library;
import com.akd.library.service.LibraryCountService;
import com.akd.library.service.LibraryCreateService;
import com.akd.library.service.LibraryDeleteService;
import com.akd.library.service.LibraryExistService;
import com.akd.library.service.LibraryReadService;

@SpringBootApplication(scanBasePackages = "com.akd.library")
public class SpringBootLibraryRestApiApplication implements CommandLineRunner {

	@Autowired
	LibraryReadService libraryService;

	@Autowired
	LibraryCreateService libraryCreateService;

	@Autowired
	LibraryCountService libraryCountService;

	@Autowired
	LibraryExistService libraryExistService;

	@Autowired
	LibraryDeleteService libraryDeleteService;

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

		// List<Library> list = new ArrayList<Library>();
		// list.add(new Library(18, "Calcutta National Library", "Swadhinota Hinotay"));
		// list.add(new Library(19, "Central Iron Library", "Indian Independence
		// Stuggle"));
		// List<Library> addedList = libraryCreateService.addAllLibraries(list);
		// System.out.println(addedList);

		// libraryCountServiceMethodsExecution();

		// libraryExistServiceMethodsExecution();

//		libraryDeleteServiceMethodsExecution();
	}

	private void libraryDeleteServiceMethodsExecution() {

		Library library1 = Library.builder().id(5).libraryName("London library").books("War and Peace").build();
		System.out.println(libraryDeleteService.deleteOneLibrary(library1));

		System.out.println(libraryDeleteService.deleteAllLibraries());

		List<Library> libraries = new ArrayList<>();
		libraries.add(Library.builder().id(1).libraryName("Oxford library").books("Rich dad Poor dad").build());
		libraries.add(Library.builder().id(2).libraryName("Newland library").books("War and Peace").build());
		libraries.add(Library.builder().id(5).libraryName("London library").books("Darkroom").build());
		libraries.add(Library.builder().id(92).libraryName("Indian library").books("Upanishads").build());
		System.out.println(libraryDeleteService.deleteAllTheseLibraries(libraries));

		System.out.println(libraryDeleteService.deleteAllLibrariesInBatch());

		System.out.println(libraryDeleteService.deleteLibraryById(6));

		List<Library> libraries2 = new ArrayList<>();
		libraries2.add(Library.builder().id(1).libraryName("Oxford library").books("Rich dad Poor dad").build());
		libraries2.add(Library.builder().id(2).libraryName("Newland library").books("War and Peace").build());
		libraries2.add(Library.builder().id(5).libraryName("London library").books("Darkroom").build());
		libraries2.add(Library.builder().id(92).libraryName("Indian library").books("Upanishads").build());
		System.out.println(libraryDeleteService.deleteTheseLibrariesInBatch(libraries2));
	}

	private void libraryExistServiceMethodsExecution() {
		long id = 9;
		System.out.println("Library with id:" + id + " exists ? " + libraryExistService.checkLibraryExistsById(id));
		String bookName = "War and Peace";
		System.out.println("Library with book:" + bookName + " exists ? "
				+ libraryExistService.checkLibraryExistsByExample(bookName));
	}

	private void libraryCountServiceMethodsExecution() {
		System.out.println("Count of libraries => " + libraryCountService.countLibraries());
		System.out
				.println("Count of libraries with zero books => " + libraryCountService.countLibrariesWithZeroBooks());
	}

}
