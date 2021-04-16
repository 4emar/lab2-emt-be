package com.lab2.laboratoriska.model.dto;

import com.lab2.laboratoriska.model.enums.ECategory;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class EditBookDto {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private ECategory eCategory;

    @NotNull
    private int availableCopies;

    @NotNull
    private Long authorId;

}
