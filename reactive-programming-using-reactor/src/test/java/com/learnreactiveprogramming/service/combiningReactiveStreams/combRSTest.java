package com.learnreactiveprogramming.service.combiningReactiveStreams;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class combRSTest {
    combRS combRS = new combRS();

    @Test
    void exploreConcatTest(){
        Flux<String> flux = combRS.exploreConcat();
        StepVerifier.create(flux).expectNext("A","B","C","D","E","F")
                .verifyComplete();
    }

    @Test
    void exploreConcatWithTest(){
        Flux<String> flux = combRS.exploreConcatWith();
        StepVerifier.create(flux).expectNext("A","B").verifyComplete();
    }

    @Test
    void exploreMergeTest(){
        Flux<String> flux = combRS.exploreMerge();
        StepVerifier.create(flux).expectNextCount(6).verifyComplete();
    }

    @Test
    void exploreMergeSequentialTest(){
        Flux<String> flux = combRS.exploreMergeSequential();
        StepVerifier.create(flux).expectNext("A","B","C","D","E","F").verifyComplete();
    }

    @Test
    void exploreZipTest(){
        Flux<String> flux = combRS.exploreZip();
        StepVerifier.create(flux).expectNext("AD1","BE2","CF3").verifyComplete();
    }
}
