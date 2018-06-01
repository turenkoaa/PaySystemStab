package com.aaturenko.paySystem.service;

import com.aaturenko.paySystem.dto.PaymentRequestDto;
import com.aaturenko.paySystem.dto.PaymentResponseDto;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Service
public class PaymentService {

    public PaymentResponseDto pay(PaymentRequestDto paymentRequestDto) {
        PaymentResponseDto paymentResponseDto;
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("payInfo.txt"))) {
            printWriter.printf("User %s paid %d rubs\n", paymentRequestDto.getEmail(), paymentRequestDto.getCost());
            printWriter.close();
            paymentResponseDto = new PaymentResponseDto("Payment successfully processed.", true);
        } catch (IOException e) {
            paymentResponseDto = new PaymentResponseDto( "Payment processing failed.", false);
            e.printStackTrace();
        }
        return paymentResponseDto;
    }
}
