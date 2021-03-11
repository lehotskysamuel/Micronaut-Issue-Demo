package com.example.demo;


import io.micronaut.http.annotation.RequestAttribute;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({PARAMETER, TYPE, METHOD, ANNOTATION_TYPE})
@RequestAttribute(DemoFilter.CUSTOM_ATTRIBUTE)
public @interface WrappingAnnotation {
}
