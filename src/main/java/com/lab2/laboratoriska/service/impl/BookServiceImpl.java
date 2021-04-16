package com.lab2.laboratoriska.service.impl;

import com.lab2.laboratoriska.model.Author;
import com.lab2.laboratoriska.model.Book;
import com.lab2.laboratoriska.model.dto.AddBookDto;
import com.lab2.laboratoriska.model.dto.EditBookDto;
import com.lab2.laboratoriska.model.dto.GetAllBooksDto;
import com.lab2.laboratoriska.model.dto.MarkBookAsTakenDto;
import com.lab2.laboratoriska.model.enums.ECategory;
import com.lab2.laboratoriska.model.exceptions.AuthorIdNotFoundException;
import com.lab2.laboratoriska.model.exceptions.BookAvailabilityException;
import com.lab2.laboratoriska.model.exceptions.BookIdNotFoundException;
import com.lab2.laboratoriska.repository.AuthorRepository;
import com.lab2.laboratoriska.repository.BookRepository;
import com.lab2.laboratoriska.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id).orElseThrow(
                () -> new BookIdNotFoundException(id)
        );
    }

    @Override
    public Book deleteById(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(
                () -> new BookIdNotFoundException(id)
        );
        this.bookRepository.deleteById(id);
        return book;
    }

    @Override
    public Book add(AddBookDto addBookDto) {

        Author author = this.authorRepository.findById(addBookDto.getAuthorId()).orElseThrow(
                () -> new AuthorIdNotFoundException(addBookDto.getAuthorId())
        );


        Book book = new Book();
        book.setName(addBookDto.getName());
        book.setCategory(addBookDto.getECategory());
        book.setAvailableCopies(addBookDto.getAvailableCopies());
        book.setAuthor(author);

        return this.bookRepository.save(book);

    }

    @Override
    public Book edit(EditBookDto editBookDto) {

        Book book = this.bookRepository.findById(editBookDto.getId()).orElseThrow(
                () -> new BookIdNotFoundException(editBookDto.getId())
        );

        Author author = this.authorRepository.findById(editBookDto.getAuthorId()).orElseThrow(
                () -> new AuthorIdNotFoundException(editBookDto.getAuthorId())
        );

        book.setName(editBookDto.getName());
        book.setAvailableCopies(editBookDto.getAvailableCopies());
        book.setAuthor(author);
        book.setCategory(editBookDto.getECategory());

        return this.bookRepository.save(book);
    }

    @Override
    public Page<GetAllBooksDto> findAll(Pageable pageable) {
        ModelMapper modelMapper = new ModelMapper();

        return this.bookRepository.findAll(pageable).map(book -> modelMapper.map(book, GetAllBooksDto.class));
    }

    @Override
    public Book markBookAsTaken(MarkBookAsTakenDto markBookAsTakenDto) {

        Book book = this.findById(markBookAsTakenDto.getId());

        if (book.getAvailableCopies() > 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
        } else
            throw new BookAvailabilityException(book.getId());

        return this.bookRepository.save(book);
    }

    @Override
    public List<ECategory> findAllCategories() {
        return List.of(ECategory.values());
    }

    @Override
    public List<GetAllBooksDto> findAll() {
        ModelMapper modelMapper = new ModelMapper();

        return this.bookRepository.findAll().stream().
                map(item -> modelMapper.map(item, GetAllBooksDto.class)).
                collect(Collectors.toList());
    }
}
