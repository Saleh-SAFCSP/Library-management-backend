package com.example.library_managment.controller;

import com.example.library_managment.model.Books;
import com.example.library_managment.model.Loan;
import com.example.library_managment.model.Logs;
import com.example.library_managment.model.Users;
import com.example.library_managment.repository.BooksRepository;
import com.example.library_managment.repository.LoanRepository;
import com.example.library_managment.repository.LogsRepository;
import com.example.library_managment.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LogsController {

    private final LogsRepository logsRepository;

    @GetMapping("/logs")
    public ResponseEntity<?> getLoans(){
        List<Logs> loans=logsRepository.findAll();
        return ResponseEntity.ok(loans);
    }


}
