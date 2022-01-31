package com.example.library_managment.repository;

import com.example.library_managment.model.Author;
import com.example.library_managment.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

}
