package it.robfrank.exercises.fizzbuzz;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FizzBuzz {

    public String execute(Stream<Integer> numbers) {
        return numbers
                .map(this::execute)
                .collect(Collectors.joining(" "));
    }

    private String execute(Integer number) {
        return switch (number) {
            case Integer n && (n % 15 == 0) -> "fizzbuzz";
            case Integer n && (n % 3 == 0) -> "fizz";
            case Integer n && (n % 5 == 0) -> "buzz";
            default -> number.toString();
        };

    }


}
