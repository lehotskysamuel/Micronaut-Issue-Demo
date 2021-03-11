package com.example.demo;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.RequestAttribute;
import io.micronaut.validation.Validated;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Validated
@Controller
@Slf4j
@AllArgsConstructor
public class DemoController {

    private final DemoService service;

    @Get("/ok")
    public String ok(@RequestAttribute(DemoFilter.CUSTOM_ATTRIBUTE) String attribute) { //this works - we can get value that was injected inside DemoFilter
        return attribute;
    }

    @Get("/nok")
    public String nok(@WrappingAnnotation String attribute) { //this annotation should work but it doesn't. It only wraps @RequestAttribute(DemoFilter.CUSTOM_ATTRIBUTE)
        return attribute;
    }

}
