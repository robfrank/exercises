package it.robfrank.exercises.fizzbuzz;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RuleBasedFizzBuzzer {

    private final List<FizzBuzzRule> rules;
    private final FizzBuzzRule defaultRule;

    protected RuleBasedFizzBuzzer(List<FizzBuzzRule> rules, FizzBuzzRule defaultRule) {
        this.rules = rules;
        this.defaultRule = defaultRule;
    }

    public String fizzBuzzerize(Stream<Integer> numbers) {
        return numbers
                .map(this::fizzBuzzerize)
                .collect(Collectors.joining(" "));
    }

    public String fizzBuzzerize(Integer number) {
        return rules.stream()
                .filter(p -> p.test(number))
                .map(f -> f.apply(number))
                .findFirst()
                .orElse(defaultRule.apply(number));
    }


}
