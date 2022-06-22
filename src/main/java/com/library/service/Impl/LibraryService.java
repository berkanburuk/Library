package com.library.service.Impl;

import com.library.dto.*;
import com.library.dto.mapper.IBookMapper;
import com.library.exception.BadRequestException;
import com.library.exception.ElementNotFoundException;
import com.library.model.Book;
import com.library.repository.IBookRepository;
import com.library.service.ILibraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LibraryService implements ILibraryService {
    private IBookRepository bookRepository;
    private IBookMapper bookMapper;

    @Autowired
    public LibraryService(IBookRepository bookRepository, IBookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> {
            log.error("İstenilen kitap bulunamadı");
            throw new ElementNotFoundException("İstenilen kitap bulunamadı.");
        });
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(BookDTO bookDTO) {
        Book book = bookMapper.toBook(bookDTO);
        if (book.getId() != null) {
            log.error("Var olan bir kitabı kaydedemezsiniz!");
            throw new BadRequestException("Var olan bir kitabı kaydedemezsiniz!");
        } else {
            Book newBook = null;
            if (book.getName() != null && !book.getName().trim().equals("")) {
                newBook = bookRepository.save(book);
            } else {
                log.info("Kitabın ismi olmalı!");
                throw new BadRequestException("Kitabın ismi olmalı!");
            }
            return newBook;
        }
    }

    @Override
    public Book updateBook(Book book) {
        boolean isBookExist = bookRepository.existsById(book.getId());
        if (!isBookExist) {
            log.error("Var olmayan kayıt güncellenemez!");
            throw new ElementNotFoundException("Kayıt edilmeyen kitap güncellenemez!");
        }
        Book persistedBook = null;
        if (book.getName() != null && !book.getName().trim().equals("")) {
            persistedBook = bookRepository.findById(book.getId()).get();
            persistedBook.setName(book.getName());
            persistedBook.setPublishDate(book.getPublishDate());
            bookRepository.save(persistedBook);
        }
        return persistedBook;
    }

    @Override
    public void deleteByBookId(Long id) {
        boolean isBookExist = bookRepository.existsById(id);
        if (!isBookExist) {
            log.error("Silmek istediğiniz kayıt bulanamamıştır!");
            throw new ElementNotFoundException("Silmek istediğiniz kayıt bulanamamıştır!");
        }
        bookRepository.deleteById(id);
    }

}
