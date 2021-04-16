package com.lab2.laboratoriska.model.dto;

import com.lab2.laboratoriska.model.enums.ECategory;
import lombok.Data;

@Data
public class AddBookDto {

    private String name;

    private ECategory eCategory;

    private int availableCopies;

    private Long authorId;

}
