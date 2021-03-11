package com.example;

import com.example.demo.DemoFilter;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
class DemoTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    void testOK() {
        String okValue = client.retrieve("/ok").blockingFirst();
        Assertions.assertEquals(okValue, DemoFilter.CUSTOM_ATTRIBUTE_VALUE);
    }

    @Test
    void testNOK() {
        String nokValue = client.retrieve("/nok").blockingFirst();
        Assertions.assertEquals(nokValue, DemoFilter.CUSTOM_ATTRIBUTE_VALUE);
    }

}
