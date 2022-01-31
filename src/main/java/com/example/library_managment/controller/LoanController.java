package com.example.library_managment.controller;

import com.example.library_managment.model.*;
import com.example.library_managment.repository.*;
import com.example.library_managment.service.LogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LoanController {

    private final BooksRepository booksRepository;
    private final UsersRepository usersRepository;
    private final LoanRepository loanRepository;
    private final LogsService logsService;


    @GetMapping("/loans")
    public ResponseEntity<?> getLoans(){
        List<Loan> loans=loanRepository.findAll();
        return ResponseEntity.ok(loans);
    }

    @PostMapping("/loans")
    public ResponseEntity<?> addLoan(@RequestBody Loan loan, Principal principal){
        Books book=booksRepository.getById(loan.getBook_id());
        Users user=usersRepository.getById(loan.getUser_id());
        loan.setBook(book);
        loan.setUser(user);
        loanRepository.save(loan);
        logsService.addLog("new loan created by "+principal.getName());
        HashMap hashMap=new HashMap();
        hashMap.put("message","New Loan created !");
        return ResponseEntity.status(201).body(hashMap);
    }
}
