package com.example.quickwindemo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class MyFirstService {

    @PersistenceContext
    private EntityManager entityManager;

    public MyFirstService() {
        System.out.println("MyFirstService constructor called");
    }

    @EventListener(classes = ApplicationReadyEvent.class)
    public void init() {
        System.out.println("MyFirstService is ready. Application has been started.");
    }

    static int counter = 0;

    @Transactional
    public HelloDto hello(String user) {
        counter++;
        String helloMessage = String.format("Hello %s, This application has been called %s times", user, counter);
        return new HelloDto(helloMessage + " " + getVisitorList(user));
    }

    private String getVisitorList(String user) {
        AppVisitorList result = entityManager.find(AppVisitorList.class, 1L);
        if (result == null) {
            AppVisitorList newList = new AppVisitorList();
            result = newList;
            entityManager.persist(newList);
        }

        result.addVisitor(user);
        return result.getListAsString();
    }
}
