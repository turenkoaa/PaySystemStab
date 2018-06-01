package com.aaturenko.paySystem.dto;

import lombok.Data;

@Data
public class PaymentRequestDto {
    private int cost;
    private String email;
}
