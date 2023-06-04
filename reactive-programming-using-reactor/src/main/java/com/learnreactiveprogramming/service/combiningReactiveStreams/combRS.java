package com.learnreactiveprogramming.service.combiningReactiveStreams;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class combRS {
    public Flux<String> exploreConcat() { //subscribes to publisher in a sequence
        Flux<String> abcFlux = Flux.just("A", "B", "C");
        Flux<String> defFlux = Flux.just("D", "E", "F");

        return Flux.concat(abcFlux, defFlux);
    }

    public Flux<String> exploreConcatWith() {
        Mono<String> aMono = Mono.just("A");
        Mono<String> bMono = Mono.just("B");

        return aMono.concatWith(bMono);
    }

    public Flux<String> exploreMerge() { //subscribes to publisher in a sequence
        Flux<String> abcFlux = Flux.just("A", "B", "C").delayElements(Duration.ofMillis(100));
        Flux<String> defFlux = Flux.just("D", "E", "F").delayElements(Duration.ofMillis(110));

        return Flux.merge(abcFlux, defFlux).log();
        // return abcFlux.mergeWith(defFlux).log(); same results as above
    }

    public Flux<String> exploreMergeSequential() { //subscribes to publisher in a sequence
        Flux<String> abcFlux = Flux.just("A", "B", "C").delayElements(Duration.ofMillis(100));
        Flux<String> defFlux = Flux.just("D", "E", "F").delayElements(Duration.ofMillis(110));

        return Flux.mergeSequential(abcFlux, defFlux).log();
    }

    public Flux<String> exploreZip(){
        Flux<String> abcFlux = Flux.just("A", "B", "C");
        Flux<String> defFlux = Flux.just("D", "E", "F");
        Flux<String> numFlux = Flux.just("1","2","3");

        return Flux.zip(abcFlux,defFlux,numFlux).map(t3 -> t3.getT1() + t3.getT2() + t3.getT3()).log();
    }

    public Mono<String> exploreZipWith() {
        Mono<String> aMono = Mono.just("A");
        Mono<String> bMono = Mono.just("B");

        return aMono.zipWith(bMono).map(t2 -> t2.getT1() + t2.getT2()); //AB
    }
}
