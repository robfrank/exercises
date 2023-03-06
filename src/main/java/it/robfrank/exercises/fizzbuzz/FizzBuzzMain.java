package it.robfrank.exercises.fizzbuzz;

import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzzMain {
    public static void main(String[] args) {

        Integer range = Integer.valueOf(args[0]);

        System.out.println("range = " + range);

        RuleBasedFizzBuzzer configurableFizzBuzzer = RuleBasedFizzBuzzer.builder()
                .withRules(List.of(
                        FizzBuzzRule.builder().withCondition(n -> n.toString().contains("3")).withMapper(n -> "robfrank").build(),
                        FizzBuzzRule.builder().withCondition(n -> n % 15 == 0).withMapper(n -> "fizzbuzz").build()))
                .withRule(FizzBuzzRule.builder().withCondition(n -> n % 5 == 0).withMapper(n -> "buzz").build())
                .withRule(FizzBuzzRule.builder().withCondition(n -> n % 3 == 0).withMapper(n -> "fizz").build())
                .withDefaultRule(FizzBuzzRule.builder().withCondition(n -> true).withMapper(n -> n.toString()).build())
                .build();

        String fizzBuzzerized = configurableFizzBuzzer.fizzBuzzerize(IntStream.rangeClosed(1, range).boxed());

        System.out.println("fizzBuzzrized = " + fizzBuzzerized);
    }
}
