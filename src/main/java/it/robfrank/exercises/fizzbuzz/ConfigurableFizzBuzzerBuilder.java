package it.robfrank.exercises.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class ConfigurableFizzBuzzerBuilder {
    private List<Rule> rules = new ArrayList<>();
    private Rule defaultRule;

    public ConfigurableFizzBuzzerBuilder withRules(List<Rule> rules) {
        this.rules.addAll(rules);
        return this;
    }
    public ConfigurableFizzBuzzerBuilder withRule(Rule rule) {
        this.rules.add(rule);
        return this;
    }

    public RuleBasedFizzBuzzer createConfigurableFizzBuzzer() {
        return new RuleBasedFizzBuzzer(rules, defaultRule);
    }

    public ConfigurableFizzBuzzerBuilder withDefaultRule(Rule defaultRule) {
        this.defaultRule = defaultRule;
        return this;
    }
}
