package com.adrian.ej5;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ContactForm {
    @NotNull(message = "You must write a name")
    @NotBlank(message = "You must write a name")
    private String name;

    @NotNull(message = "You must write a dni")
    @NotBlank(message = "You must write a dni")
    private String dni;

    @NotNull(message = "You must write an email")
    @NotBlank(message = "You must write an email")
    @Email(message = "The email must have a valid format")
    private String email;

    @NotNull(message = "You must write a direction")
    @NotBlank(message = "You must write a direction")
    private String direction;

    @NotNull(message = "You must select a product type")
    @NotBlank(message = "You must write a product type")
    private String productType;

    @AssertTrue(message = "You must accept our conditions")
    private Boolean conditions;
}
