package com.adrian.ej3;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class VoteForm {
    @NotNull(message = "Must select one movie")
    private Integer movie;

    @Email(message = "Must write a valid email")
    @NotEmpty(message = "Must write an email")
    private String email;

    public Integer getMovie() {
        return movie;
    }

    public void setMovie(Integer movie) {
        this.movie = movie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
