package com.learnreactiveprogramming.service.mono;

import reactor.core.publisher.Mono;

public class nameMono {
    public static Mono<String> nameMono(){
        return Mono.just("Name");
    }

    public static void printMono(){
        nameMono().subscribe(name -> System.out.println(name));
    }
}
