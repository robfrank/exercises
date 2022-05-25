package it.robfrank.exercises.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class RuleBasedFizzBuzzerBuilder {
    private List<FizzBuzzRule> rules = new ArrayList<>();
    private FizzBuzzRule defaultRule;

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
