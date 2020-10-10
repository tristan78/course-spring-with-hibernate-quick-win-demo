package com.example.quickwindemo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    public MyFirstService() {
        System.out.println("MyFirstService constructor called");
    }

    @EventListener(classes = ApplicationReadyEvent.class)
    public void init(){
        System.out.println("MyFirstService is ready. Application has been started.");
    }
}
