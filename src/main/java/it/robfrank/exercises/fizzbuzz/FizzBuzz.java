package it.robfrank.exercises.fizzbuzz;

import java.util.List;
import java.util.stream.Collectors;

public class FizzBuzz {

    public String execute(List<Integer> numbers) {
        return numbers.stream()
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
