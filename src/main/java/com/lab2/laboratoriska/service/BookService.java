package com.lab2.laboratoriska.service;


import com.lab2.laboratoriska.model.Book;
import com.lab2.laboratoriska.model.dto.AddBookDto;
import com.lab2.laboratoriska.model.dto.EditBookDto;
import com.lab2.laboratoriska.model.dto.GetAllBooksDto;
import com.lab2.laboratoriska.model.dto.MarkBookAsTakenDto;
import com.lab2.laboratoriska.model.enums.ECategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    Book findById(Long id);

    Book deleteById(Long id);

    Book add(AddBookDto addBookDto);

    Book edit(EditBookDto editBookDto);

    Page<GetAllBooksDto> findAll(Pageable pageable);

    Book markBookAsTaken(MarkBookAsTakenDto markBookAsTakenDto);

    List<ECategory> findAllCategories();

    List<GetAllBooksDto> findAll();
}
