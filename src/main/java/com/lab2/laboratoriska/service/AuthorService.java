package com.lab2.laboratoriska.service;

import com.lab2.laboratoriska.model.Author;
import com.lab2.laboratoriska.model.dto.GetAuthorNameAndSurnameDto;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    Author deleteById(Long id);

    Author findById(Long id);

    List<GetAuthorNameAndSurnameDto> getAuthorsForEdit();

}
