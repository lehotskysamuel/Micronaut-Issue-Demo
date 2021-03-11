package com.example.demo;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.OncePerRequestHttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import io.micronaut.http.filter.ServerFilterPhase;
import org.reactivestreams.Publisher;

@Filter("/**")
public class DemoFilter extends OncePerRequestHttpServerFilter {

    public static final String CUSTOM_ATTRIBUTE = "example.customAttribute";
    public static final String CUSTOM_ATTRIBUTE_VALUE = "We injected custom value as a request attribute";

    @Override
    public int getOrder() {
        return ServerFilterPhase.SECURITY.after();
    }

    @Override
    protected Publisher<MutableHttpResponse<?>> doFilterOnce(HttpRequest<?> request, ServerFilterChain chain) {
        request.getAttributes().put(CUSTOM_ATTRIBUTE, CUSTOM_ATTRIBUTE_VALUE);
        return chain.proceed(request);
    }
}
