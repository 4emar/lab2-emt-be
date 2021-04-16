package com.lab2.laboratoriska.model.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class GetAuthorNameAndSurnameDto {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;


}
