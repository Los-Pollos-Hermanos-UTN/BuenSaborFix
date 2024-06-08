package com.example.buensaboruno.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersByCategoryDTO {
    private String categoryName;
    private Long orderCount;

}
