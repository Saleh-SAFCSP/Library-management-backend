package com.example.library_managment.controller;


import com.example.library_managment.model.Author;
import com.example.library_managment.model.Genre;
import com.example.library_managment.repository.AuthorRepository;
import com.example.library_managment.repository.GenreRepository;
import com.example.library_managment.service.LogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final LogsService logsService;

    @GetMapping("/author")
    public ResponseEntity<?> getAuthors(){
        List<Author> authors=authorRepository.findAll();
        return ResponseEntity.ok(authors);
    }

    @PostMapping("/author")
    public ResponseEntity<?> addAuthor(@RequestBody @Valid Author author, Principal principal){
        authorRepository.save(author);
        logsService.addLog("new author created by "+principal.getName());
        HashMap hashMap=new HashMap();
        hashMap.put("message","New author created !");
        return ResponseEntity.status(201).body(hashMap);
    }
}
