package com.example.library_managment.controller;


import com.example.library_managment.model.Genre;
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
public class GenreController {


    private final GenreRepository genreRepository;
    private final LogsService logsService;

    @GetMapping("/genre")
    public ResponseEntity<?> getGenre(){
        List<Genre> genres=genreRepository.findAll();
        return ResponseEntity.ok(genres);
    }

    @PostMapping("/genre")
    public ResponseEntity<?> addGenre(@RequestBody @Valid Genre genre, Principal principal){
        genreRepository.save(genre);
        logsService.addLog("new genre created by "+principal.getName());
        HashMap hashMap=new HashMap();
        hashMap.put("message","New genre created !");
        return ResponseEntity.status(201).body(hashMap);
    }
}
