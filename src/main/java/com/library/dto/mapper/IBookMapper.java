package com.library.dto.mapper;

import com.library.dto.BookDTO;
import com.library.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper(componentModel = "spring")
public interface IBookMapper {

    @Mappings({
            @Mapping(target = "fullName", source = "book.name"),
            @Mapping(target = "publishYear", source = "book.publishDate")
    })
    BookDTO toBookDTO(Book book);

    @Mappings({
            @Mapping(target = "fullName", source = "bookList.name"),
            @Mapping(target = "publishYear", source = "bookList.publishDate" /*,  dateFormat = "dd-MM-yyyy HH:mm:ss"*/)
    })
    List<BookDTO> toBookDTOList(List<Book> bookList);

    @Mappings({
            @Mapping(target = "name", source = "bookDTO.fullName"),
            @Mapping(target = "publishDate", source = "bookDTO.publishYear")
    })
    Book toBook(BookDTO bookDTO);

}
