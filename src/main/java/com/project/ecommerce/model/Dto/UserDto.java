package com.project.ecommerce.model.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class UserDto {

    @NotBlank(message = "Username is required")
    private String name;

    @NotBlank(message = "Username is required")
    private String username;

    @Min(value = 6,message = "password must be at least 6 character")
    private String password;
}
