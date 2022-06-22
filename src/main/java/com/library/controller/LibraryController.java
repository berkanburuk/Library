package com.library.controller;

import com.library.dto.BookDTO;
import com.library.dto.IBookMapper;
import com.library.model.Book;
import com.library.service.Impl.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {
    LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Book getBook(@PathVariable("id") Long id) {
        return libraryService.getBookById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(BookDTO bookDTO) {
        return libraryService.saveBook(bookDTO);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(Book book) {
        return libraryService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable("id") Long id) {
        libraryService.deleteByBookId(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBook() {
        return libraryService.getAllBooks();
    }

}
