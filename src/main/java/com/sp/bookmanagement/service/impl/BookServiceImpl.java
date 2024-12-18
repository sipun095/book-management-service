package com.sp.bookmanagement.service.impl;

import com.sp.bookmanagement.dto.BookDTO;
import com.sp.bookmanagement.entity.Book;
import com.sp.bookmanagement.entity.Category;
import com.sp.bookmanagement.repository.BookRepository;
import com.sp.bookmanagement.repository.CategoryRepository;
import com.sp.bookmanagement.service.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookRepository bookRepository;
    @Override
    @Transactional
    public BookDTO createdBook(BookDTO bookDTO) {
        System.out.println("hhjjj");

        Category category=categoryRepository.findByName(bookDTO.getCategoryName()).orElseThrow(() -> new RuntimeException("category Not found"));

        Book book= Book.builder()
                .title(bookDTO.getTitle())
                .author(bookDTO.getAuthor())
                .description(bookDTO.getDescription())
                .price(bookDTO.getPrice())
                .isbn(bookDTO.getIsbn())
                .publicationDate(bookDTO.getPublicationDate())
                .stockQuantity(bookDTO.getStockQuantity())
                .imageUrl(bookDTO.getImgUrl())
                .category(category)
                .build();

        return mapToDTO(bookRepository.save(book));

    }

    private BookDTO mapToDTO(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .description(book.getDescription())
                .price(book.getPrice())
                .isbn(book.getIsbn())
                .imgUrl(book.getImageUrl())
                .publicationDate(book.getPublicationDate())
                .categoryName(book.getCategory().getName())
                .stockQuantity(book.getStockQuantity())
                .build();
    }

    @Override
    public BookDTO getBookByID(Long id) {
        return mapToDTO(bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book  not found")));
    }

    @Override
    public Page<BookDTO> getAllBooks(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        Page<Book> books=bookRepository.findAll(pageable);
        return books.map(this::mapToDTO) ;
    }

    @Override
    public void  deleteBookByID(Long id) {
      bookRepository.deleteById(id);
    }
}
