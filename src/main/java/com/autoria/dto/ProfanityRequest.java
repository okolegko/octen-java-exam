package com.autoria.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProfanityRequest {
    @NotBlank
    private String text;
}
