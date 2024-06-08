package com.example.buensaboruno.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopSellingProductDTO {
    private String productName;
    private Long quantitySold;
}
