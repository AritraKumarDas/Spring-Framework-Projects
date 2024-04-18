package com.akd.library.service;

public interface LibraryExistService {

	boolean checkLibraryExistsById(long id);

	boolean checkLibraryExistsByExample(String bookName);

}