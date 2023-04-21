package com.exampledto.dtoSpring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BikeResponse {
    private int id;
    private String name;
    private String company;
    private double price;

}
