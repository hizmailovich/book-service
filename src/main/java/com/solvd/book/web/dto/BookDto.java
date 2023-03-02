package com.solvd.book.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public record BookDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long id,

        @NotBlank(message = "Title can't be blank!")
        String title,

        @NotBlank(message = "Author can't be blank!")
        Long authorId

) {
}
