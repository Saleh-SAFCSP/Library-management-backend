package com.example.library_managment.controller;

import com.example.library_managment.model.Author;
import com.example.library_managment.model.Books;
import com.example.library_managment.model.Genre;
import com.example.library_managment.repository.AuthorRepository;
import com.example.library_managment.repository.BooksRepository;
import com.example.library_managment.repository.GenreRepository;
import com.example.library_managment.service.LogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController {

    private final BooksRepository booksRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final LogsService logsService;


    @GetMapping("/books")
    public ResponseEntity<?> getBooks(){
        List<Books> books=booksRepository.findAll();
        return ResponseEntity.ok(books);
    }

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody Books book, Principal principal){
        Author author=authorRepository.getById(book.getAuthor_id());
        Genre genre=genreRepository.getById(book.getGenre_id());
        book.setAuthor(author);
        book.setGenre(genre);
        booksRepository.save(book);
        logsService.addLog("new book created by "+principal.getName());
        HashMap hashMap=new HashMap();
        hashMap.put("message","New book created !");
        return ResponseEntity.status(201).body(hashMap);
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId, Principal principal){
        Optional<Books> book= booksRepository.findById(bookId);
        HashMap hashMap=new HashMap();
        if(!book.isPresent()){
            hashMap.put("message","No book founded with the given id");
            return ResponseEntity.status(400).body(hashMap);
        }
        booksRepository.deleteById(bookId);
        logsService.addLog("book with id "+bookId+" deleted by "+principal.getName());

        hashMap.put("message","Book deleted");
        return ResponseEntity.status(200).body(hashMap);
    }

}
