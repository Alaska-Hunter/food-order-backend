package com.mycompany.myapp.service.dto;

// DTO: Data transfer object

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FoodDTO {
    private String FoodName;
    private double price;
}
