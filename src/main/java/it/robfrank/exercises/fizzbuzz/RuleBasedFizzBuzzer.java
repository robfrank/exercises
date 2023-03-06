package it.robfrank.exercises.fizzbuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RuleBasedFizzBuzzer {

    private final List<FizzBuzzRule> rules;
    private final FizzBuzzRule defaultRule;

    private RuleBasedFizzBuzzer(List<FizzBuzzRule> rules, FizzBuzzRule defaultRule) {
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

    public static RuleBasedFizzBuzzerBuilder builder() {
        return new RuleBasedFizzBuzzerBuilder();
    }


    public static class RuleBasedFizzBuzzerBuilder {
        private List<FizzBuzzRule> rules = new ArrayList<>();
        private FizzBuzzRule defaultRule;

        private RuleBasedFizzBuzzerBuilder(){

        }

        public RuleBasedFizzBuzzerBuilder withRules(List<FizzBuzzRule> rules) {
            this.rules.addAll(rules);
            return this;
        }
        public RuleBasedFizzBuzzerBuilder withRule(FizzBuzzRule rule) {
            this.rules.add(rule);
            return this;
        }

        public RuleBasedFizzBuzzer build() {
            return new RuleBasedFizzBuzzer(rules, defaultRule);
        }

        public RuleBasedFizzBuzzerBuilder withDefaultRule(FizzBuzzRule defaultRule) {
            this.defaultRule = defaultRule;
            return this;
        }
    }
}
