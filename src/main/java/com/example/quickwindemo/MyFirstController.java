package com.example.quickwindemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {

    static int counter = 0;

    @GetMapping
    public HelloDto hello() {
        counter++;
        return new HelloDto(String.format("This application has been called %s times", counter));
    }

    public static class HelloDto {
        private String text;

        public HelloDto(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
