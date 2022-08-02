package it.robfrank.exercises.fizzbuzz;

import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzzMain {
    public static void main(String[] args) {

        Integer range = Integer.valueOf(args[0]);

        RuleBasedFizzBuzzer configurableFizzBuzzer = new RuleBasedFizzBuzzerBuilder()
                .withRules(List.of(
                        new FizzBuzzRuleBuilder().withCondition(n -> n.toString().contains("3")).withMapper(n -> "robfrank").build(),
                        new FizzBuzzRuleBuilder().withCondition(n -> n % 15 == 0).withMapper(n -> "fizzbuzz").build()))
                .withRule(new FizzBuzzRuleBuilder().withCondition(n -> n % 5 == 0).withMapper(n -> "buzz").build())
                .withRule(new FizzBuzzRuleBuilder().withCondition(n -> n % 3 == 0).withMapper(n -> "fizz").build())
                .withDefaultRule(new FizzBuzzRuleBuilder().withCondition(n -> true).withMapper(n -> n.toString()).build())
                .build();

        String s = configurableFizzBuzzer.fizzBuzzerize(IntStream.rangeClosed(1, range).boxed());
    }
}
