package com.learnreactiveprogramming.service.mono;

import lombok.var;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class nameMono {
    public static Mono<String> nameMono(){
        return Mono.just("Name");
    }

    public static void printMono(){
        nameMono().subscribe(name -> System.out.println(name));
    }

    public Mono<List<String>> wordMonoFlatMap(){
        return Mono.just("word")
                .map(String::toUpperCase)
                .flatMap(this::splitString);
    }

    private Mono<List<String>> splitString(String s) {
        return Mono.just(List.of(s.split("")));
    }

    public Flux<List<String>> wordMonoFlatMapMany(){
        return Mono.just("word")
                .map(String::toUpperCase)
                .flatMapMany(this::splitString)//returns FLUX instead of MONO
                .log();
    }

    public Mono<String> emptyMono(){
        return Mono.just("looong")
                .filter(s -> s.length() < 2)
                .defaultIfEmpty("default");
    }

    public Mono<String> switchIfEmptyMono(){

        Mono<String> defaultPub = Mono.just("switchIfEmpty");

        return Mono.just("just")
                .filter(s -> s.length() < 1)
                .switchIfEmpty(defaultPub);
    }
}
