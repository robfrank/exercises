package it.robfrank.exercises.fizzbuzz.web;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import it.robfrank.exercises.fizzbuzz.FizzBuzzRule;
import it.robfrank.exercises.fizzbuzz.RuleBasedFizzBuzzer;
import java.util.List;
import java.util.stream.IntStream;
import org.jetbrains.annotations.NotNull;

public class FizzBuzzHandler implements Handler {

    private final RuleBasedFizzBuzzer fizzBuzzer;

    public FizzBuzzHandler() {
        this.fizzBuzzer = RuleBasedFizzBuzzer
                .builder()
                .withRules(
                        List.of(
                                FizzBuzzRule.builder().withCondition(n -> n.toString().contains("3")).withMapper(n -> "robfrank").build(),
                                FizzBuzzRule.builder().withCondition(n -> n % 15 == 0).withMapper(n -> "fizzbuzz").build()
                        )
                )
                .withRule(FizzBuzzRule.builder().withCondition(n -> n % 5 == 0).withMapper(n -> "buzz").build())
                .withRule(FizzBuzzRule.builder().withCondition(n -> n % 3 == 0).withMapper(n -> "fizz").build())
                .withDefaultRule(FizzBuzzRule.builder().withCondition(n -> true).withMapper(Object::toString).build())
                .build();

    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        int range = Integer.parseInt(context.pathParam("range"));
        context.result(fizzBuzzer.fizzBuzzerize(IntStream.rangeClosed(1, range).boxed()));
    }
}
