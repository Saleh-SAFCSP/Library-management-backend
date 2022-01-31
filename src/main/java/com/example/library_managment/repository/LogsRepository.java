package com.example.library_managment.repository;

import com.example.library_managment.model.Genre;
import com.example.library_managment.model.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsRepository extends JpaRepository<Logs,Long> {

}
