package com.library.service;

import com.library.dto.*;
import com.library.model.Book;

import java.util.List;

public interface ILibraryService {
    Book getBookById(Long id);

    List<Book> getAllBooks();

    Book saveBook(BookDTO book);

    Book updateBook(Book book);

    void deleteByBookId(Long id);

}
