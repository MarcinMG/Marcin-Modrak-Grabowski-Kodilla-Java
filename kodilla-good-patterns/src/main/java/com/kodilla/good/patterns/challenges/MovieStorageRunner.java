package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class MovieStorageRunner {
    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();

        String resultMovie = movieStore.getMovies().entrySet().stream()
                .flatMap(s -> s.getValue().stream())
                .collect(Collectors.joining("!"));

        System.out.println(resultMovie);
        }
}
