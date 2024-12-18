package com.sp.bookmanagement.controller;

import com.sp.bookmanagement.dto.BookDTO;
import com.sp.bookmanagement.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
//@RequiredArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<BookDTO> createdBook(@RequestBody BookDTO bookDTO){
    //return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createdBook(bookDTO));
        return ResponseEntity.ok(bookService.createdBook(bookDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookByID(@PathVariable Long id){
        return  ResponseEntity.ok(bookService.getBookByID(id));
    }
    @GetMapping("/getAllBooks")
    public ResponseEntity<Page<BookDTO>> getAllBooks(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(bookService.getAllBooks(page,size));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookByID(@PathVariable Long id){
        bookService.deleteBookByID(id);
        return ResponseEntity.noContent().build();
    }
}

