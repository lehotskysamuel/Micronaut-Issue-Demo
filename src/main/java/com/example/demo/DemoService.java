package com.example.demo;

import javax.inject.Singleton;
import javax.validation.constraints.NotBlank;

@Singleton
public class DemoService {

    public void sayHello(@NotBlank String name) {
        System.out.println("Hello " + name);
    }
}
