package com.example.buensaboruno.domain.dtos;

import lombok.Builder;

@Builder
public class ErrorDTO {
    private String errorMsg;
    private String errorClass;
}
