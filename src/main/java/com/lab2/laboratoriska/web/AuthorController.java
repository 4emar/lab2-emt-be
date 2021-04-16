package com.lab2.laboratoriska.web;


import com.lab2.laboratoriska.model.Author;
import com.lab2.laboratoriska.model.dto.GetAuthorNameAndSurnameDto;
import com.lab2.laboratoriska.service.AuthorService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "api/author", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAll(){
        return ResponseEntity.ok(this.authorService.findAll());
    }

    @DeleteMapping("/librairan/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long id){
        return ResponseEntity.ok(this.authorService.deleteById(id));
    }

    @GetMapping("/ibrarian/getAuthorsForEdit")
    public ResponseEntity<List<GetAuthorNameAndSurnameDto>> getAuthorForEdit(){
        return ResponseEntity.ok(this.authorService.getAuthorsForEdit());
    }


}
