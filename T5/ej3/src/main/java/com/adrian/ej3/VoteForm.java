package com.adrian.ej3;

import jakarta.validation.constraints.NotNull;

public class VoteForm {
    @NotNull
    private Integer movie;

    @NotNull
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
