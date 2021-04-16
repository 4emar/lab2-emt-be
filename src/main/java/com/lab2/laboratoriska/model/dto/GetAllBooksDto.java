package com.lab2.laboratoriska.model.dto;

import com.lab2.laboratoriska.model.enums.ECategory;
import lombok.Data;

@Data
public class GetAllBooksDto {

    private Long id;

    private String name;

    private ECategory eCategory;

    private int availableCopies;

    private String authorName;

    private String authorSurname;

    private Long authorId;

}
