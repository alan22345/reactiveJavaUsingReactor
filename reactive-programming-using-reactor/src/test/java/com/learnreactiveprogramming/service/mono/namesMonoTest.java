package com.learnreactiveprogramming.service.mono;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class namesMonoTest {
    nameMono nameMono = new nameMono();

    @Test
    void emptyMonoTest(){
        Mono<String> a = nameMono.emptyMono();
        StepVerifier.create(a).expectNext("default").verifyComplete();
    }

    @Test
    void switchIfEmptyMono() {
        Mono<String> a = nameMono.switchIfEmptyMono();
        StepVerifier.create(a).expectNext("switchIfEmpty").verifyComplete();
    }
}
