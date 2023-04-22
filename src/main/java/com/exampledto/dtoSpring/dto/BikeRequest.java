package com.exampledto.dtoSpring.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BikeRequest {
    @NotBlank(message = "Please enter proper bike name")
    private String name;
    private String company;
    private double price;
}
