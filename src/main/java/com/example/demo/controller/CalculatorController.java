package com.example.demo.controller;

import com.example.demo.service.Calculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ( "/calculator")
public class CalculatorController {

    private final Calculator calculator;
    public CalculatorController ( Calculator calculator ) {
        this.calculator = calculator;
    }
    @GetMapping
    public String showGreetings() {
        return " Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam int num1, @RequestParam int num2) {
        int results = calculator.plus(num1,num2);
        return createRs(num1,num2, '+', results);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam int num1, @RequestParam int num2) {
        int results = calculator.minus(num1,num2);
        return createRs(num1,num2, '-', results);
    }

    @GetMapping("/multiply")
    public String multiply (@RequestParam int num1, @RequestParam int num2) {
        int results = calculator.multiply(num1,num2);
        return createRs(num1,num2, '*', results);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam int num1, @RequestParam int num2) {
        int results = calculator.divide(num1,num2);
        return createRs(num1,num2, '/', results);
    }

    private String createRs ( int num1, int num2, char action, int results) {
        return String.format(" %d %c %d = %d", num1,action,num2, results);
    }
}