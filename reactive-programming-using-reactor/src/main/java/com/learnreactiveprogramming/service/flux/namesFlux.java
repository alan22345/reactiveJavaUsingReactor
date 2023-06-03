package com.learnreactiveprogramming.service.flux;

import reactor.core.publisher.Flux;

import java.util.List;

public class namesFlux {

    public static Flux<String> namesFlux(){
        //returns events from Flux with .log()
        return Flux.fromIterable(List.of("a","b","c"));
    }

    public static void printFlux(){
        namesFlux().subscribe(name -> System.out.println(name));
    }
}
