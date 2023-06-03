package com.learnreactiveprogramming.service;

import com.learnreactiveprogramming.service.flux.namesFlux;
import com.learnreactiveprogramming.service.mono.nameMono;


public class FluxAndMonoGeneratorService {
    public static void main(String[] args) {
        namesFlux.printFlux();
        nameMono.printMono();
    }
}
