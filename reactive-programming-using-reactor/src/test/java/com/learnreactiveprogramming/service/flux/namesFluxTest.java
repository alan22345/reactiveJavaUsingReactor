package com.learnreactiveprogramming.service.flux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class namesFluxTest {
    namesFlux namesFlux = new namesFlux();

    @Test
    void namesFlux(){
        Flux<String> names = namesFlux.namesFlux();

        StepVerifier.create(names).expectNext("a","b","c").verifyComplete();
    }
}
