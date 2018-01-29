package com.kodilla.stream.zadanie;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static long getCountEmptyStringUsingJava8(List<String> list) {
        return list.stream().filter(String::isEmpty).count();
    }

    public static long getCountLength3UsingJava8(List<String> strings) {
        return strings.stream().filter(n -> n.length() == 3).count();
    }

    public static List<String> deleteEmptyStringsUsingJava8(List<String> strings) {
        return strings.stream().filter(n -> n.length() > 0).collect(Collectors.toList());
    }

    public static String getMergedStringUsingJava8(List<String> strings, String s) {
        return strings.stream().filter(n -> n.length() > 0).collect(Collectors.joining(","));
    }

    public static List<Integer> getSquaresJava8(List<Integer> numbers) {
        return numbers.stream().distinct().map(n -> n*n).collect(Collectors.toList());
    }

    public static Integer getMaxJava8(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare).get();
    }

    public static Integer getMinJava8(List<Integer> numbers) {
        return numbers.stream().min(Integer::compare).get();
    }

    public static Integer getSumJava8(List<Integer> numbers) {
        return numbers.stream().mapToInt(n -> n).sum();
    }

    public static Integer getAverageJava8(List<Integer> numbers) {
        Double d = numbers.stream().mapToInt(n -> n).average().getAsDouble();
        return d.intValue();
    }
}
