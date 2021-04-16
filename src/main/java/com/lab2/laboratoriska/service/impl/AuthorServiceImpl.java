package com.lab2.laboratoriska.service.impl;

import com.lab2.laboratoriska.model.Author;
import com.lab2.laboratoriska.model.dto.GetAuthorNameAndSurnameDto;
import com.lab2.laboratoriska.model.exceptions.AuthorIdNotFoundException;
import com.lab2.laboratoriska.repository.AuthorRepository;
import com.lab2.laboratoriska.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author deleteById(Long id) {
        Author author = this.authorRepository.findById(id).orElseThrow(
                () -> new AuthorIdNotFoundException(id)
        );
        this.authorRepository.deleteById(id);
        return author;

    }

    @Override
    public Author findById(Long id) {
        return this.authorRepository.findById(id).orElseThrow(() -> new AuthorIdNotFoundException(id));
    }

    @Override
    public List<GetAuthorNameAndSurnameDto> getAuthorsForEdit() {
        ModelMapper modelMapper = new ModelMapper();

        return this.findAll().stream().map(author -> modelMapper
                .map(author, GetAuthorNameAndSurnameDto.class)).collect(Collectors.toList());

    }
}
