package it.robfrank.exercises.fizzbuzz;

import java.util.function.Function;
import java.util.function.Predicate;

public class FizzBuzzRule implements Predicate<Integer>, Function<Integer, String> {

    private final Predicate<Integer> condition;
    private final Function<Integer, String> mapper;

    FizzBuzzRule(Predicate<Integer> condition, Function<Integer, String> mapper) {
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


}
