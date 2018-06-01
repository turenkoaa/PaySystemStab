package com.aaturenko.paySystem.controller;

import com.aaturenko.paySystem.dto.PaymentRequestDto;
import com.aaturenko.paySystem.dto.PaymentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aaturenko.paySystem.service.PaymentService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<PaymentResponseDto> addPayment(@RequestBody PaymentRequestDto paymentRequestDto) {
        return ResponseEntity.ok(paymentService.pay(paymentRequestDto));
    }
}
