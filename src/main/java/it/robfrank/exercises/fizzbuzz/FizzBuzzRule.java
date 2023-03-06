package it.robfrank.exercises.fizzbuzz;

import java.util.function.Function;
import java.util.function.Predicate;

public class FizzBuzzRule implements Predicate<Integer>, Function<Integer, String> {

    private final Predicate<Integer> condition;
    private final Function<Integer, String> mapper;

    private FizzBuzzRule(Predicate<Integer> condition, Function<Integer, String> mapper) {
        this.condition = condition;
        this.mapper = mapper;
    }


    @Override
    public boolean test(Integer number) {
        return condition.test(number);
    }

    @Override
    public String apply(Integer number) {
        return mapper.apply(number);
    }

    public static FizzBuzzRuleBuilder builder() {
        return new FizzBuzzRuleBuilder();
    }

    public static class FizzBuzzRuleBuilder {
        private Predicate<Integer> condition;
        private Function<Integer, String> mapper;

        private FizzBuzzRuleBuilder() {
        }

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
}
