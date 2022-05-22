package it.robfrank.exercises.fizzbuzz;

import java.util.function.Function;
import java.util.function.Predicate;

public class Rule implements Predicate<Integer>, Function<Integer, String> {

    private final Predicate<Integer> condition;
    private final Function<Integer, String> mapper;

    private Rule(Predicate<Integer> condition , Function<Integer, String>  mapper ) {
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


    public static class RuleBuilder {
        private Predicate<Integer> condition;
        private Function<Integer, String> mapper;

        public RuleBuilder withCondition(Predicate<Integer> condition) {
            this.condition = condition;
            return this;
        }

        public RuleBuilder withMapper(Function<Integer, String> mapper) {
            this.mapper = mapper;
            return this;
        }

        public Rule createRule() {

            return new Rule(condition, mapper);
        }
    }
}
