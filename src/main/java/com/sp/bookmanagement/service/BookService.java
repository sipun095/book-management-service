package com.sp.bookmanagement.service;

import com.sp.bookmanagement.dto.BookDTO;
import org.springframework.data.domain.Page;

public interface BookService {
    BookDTO createdBook(BookDTO bookDTO);

    BookDTO getBookByID(Long id);

    Page<BookDTO> getAllBooks(int page, int size);

    void deleteBookByID(Long id);
}
