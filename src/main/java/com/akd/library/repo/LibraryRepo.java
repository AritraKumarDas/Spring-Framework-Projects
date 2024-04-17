package com.akd.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akd.library.entity.Library;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Long> {

}
