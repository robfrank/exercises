package it.robfrank.exercises.fizzbuzz;

import java.util.function.Function;
import java.util.function.Predicate;

public class FizzBuzzRuleBuilder {
    private Predicate<Integer> condition;
    private Function<Integer, String> mapper;

    public FizzBuzzRuleBuilder withCondition(Predicate<Integer> condition) {
        this.condition = condition;
        return this;
    }

    public FizzBuzzRuleBuilder withMapper(Function<Integer, String> mapper) {
        this.mapper = mapper;
        return this;
    }

    public FizzBuzzRule build() {

        return new FizzBuzzRule(condition, mapper);
    }
}
