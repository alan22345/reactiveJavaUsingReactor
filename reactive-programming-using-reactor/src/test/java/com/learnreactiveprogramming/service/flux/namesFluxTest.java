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

    @Test
    void namesFluxMap(){
        Flux<String> names = namesFlux.namesFluxMap();
        StepVerifier.create(names).expectNext("A","B","C").verifyComplete();
    }

    @Test
    void namesFluxImmutability() {
        Flux<String> names = namesFlux.namesFluxImmutability();
        StepVerifier.create(names).expectNext("a","b","c").verifyComplete();
    }

    @Test
    void namesFluxFilter() {
        Flux<String> words = namesFlux.namesFluxFilter();
        StepVerifier.create(words).expectNext("BIGGER","BIGGEST").verifyComplete();
    }

    @Test
    void fluxFlatMap() {
        Flux<String> letters = namesFlux.fluxFlatMap();
        StepVerifier.create(letters)
                .expectNext("w","o","r","d","1","2","3","w","o","r","d","3","4").verifyComplete();
    }

    @Test
    void fluxFlatMapAsyncDemo() {
        Flux<String> letters = namesFlux.fluxFlatMapAsyncDemo();
        StepVerifier.create(letters).expectNextCount(13).verifyComplete();
    }

    @Test
    void fluxTransform() {
        Flux<String> letters = namesFlux.fluxFlatMap();
        StepVerifier.create(letters)
                .expectNext("w","o","r","d","1","2","3","w","o","r","d","3","4").verifyComplete();
    }
}
