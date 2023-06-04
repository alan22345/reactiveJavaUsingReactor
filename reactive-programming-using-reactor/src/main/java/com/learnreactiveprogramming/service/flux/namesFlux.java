package com.learnreactiveprogramming.service.flux;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class namesFlux {

    public static Flux<String> namesFlux(){
        //returns events from Flux with .log()
        return Flux.fromIterable(List.of("a","b","c"));
    }

    public Flux<String> namesFluxMap(){
        return Flux.fromIterable(List.of("a","b","c"))
                .map(String::toUpperCase);
    }

    public Flux<String> namesFluxImmutability(){
        Flux<String> names = Flux.fromIterable(List.of( "a","b","c"));
        names.map(String::toUpperCase);
        return names;
    }

    public Flux<String> namesFluxFilter(){
        return Flux.fromIterable(List.of("big","bigger","biggest"))
                .filter(a -> a.length() > 4) //hard coding exception
                .map(String::toUpperCase);
    }

    public static void printFlux(){
        namesFlux().subscribe(name -> System.out.println(name));
    }

    public Flux<String> fluxFlatMap(){
        return Flux.fromIterable(List.of("Word1","Word123","Word34"))
                .map(String::toLowerCase)
                .filter(s -> s.length() > 5) //hard coding exception
                .flatMap(s-> splitString(s));
    }

    public Flux<String> fluxFlatMapAsyncDemo(){
        return Flux.fromIterable(List.of("Word1","Word123","Word34"))
                .map(String::toLowerCase)
                .filter(s -> s.length() > 5) //hard coding exception
                .flatMap(s-> splitStringDelay(s))
                //concatMap(s-> splitStringDelay(s)) gives us the elements in the same order
                .log();
    }

    private Flux<String> splitString(String word){
        String[] splitLetters = word.split("");
        return Flux.fromArray(splitLetters);
    }
    private Flux<String> splitStringDelay(String word){
        String[] splitLetters = word.split("");
        return Flux.fromArray(splitLetters)
                .delayElements(Duration.ofMillis(new Random().nextInt(1000)));
    }

    public Flux<String> fluxTransform(){

        Function<Flux<String>,Flux<String>> filterMap = name -> name.map(String::toLowerCase)
                .filter(s -> s.length() > 5);

        return Flux.fromIterable(List.of("Word1","Word123","Word34"))
                .transform(filterMap)//hard coding exception
                .flatMap(s-> splitString(s));
    }


}
