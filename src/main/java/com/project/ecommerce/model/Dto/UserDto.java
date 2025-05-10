package com.project.ecommerce.model.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class UserDto {

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "Username is required")
    private String username;

    @Size(min = 6)
    private String password;
}
