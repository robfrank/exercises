package it.robfrank.exercises.fizzbuzz;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static it.robfrank.exercises.fizzbuzz.FizzBuzzTest.ROBFRANK_FIZZBUZZ_EXPECTED_RESULT_WITH_RANGE_1_TO_20;
import static org.assertj.core.api.Assertions.assertThat;

class RuleBasedFizzBuzzerTest {

    final Stream<Integer> range1To20 = IntStream.rangeClosed(1, 20).boxed();

    @Test
    void whenRunningConfigurableFizzBuzz_ThenReturnExpectedOutput() {

        RuleBasedFizzBuzzer configurableFizzBuzzer = new RuleBasedFizzBuzzerBuilder()
                .withRules(List.of(
                        new FizzBuzzRuleBuilder().withCondition(n -> n.toString().contains("3")).withMapper(n -> "robfrank").build(),
                        new FizzBuzzRuleBuilder().withCondition(n -> n % 15 == 0).withMapper(n -> "fizzbuzz").build()))
                .withRule(new FizzBuzzRuleBuilder().withCondition(n -> n % 5 == 0).withMapper(n -> "buzz").build())
                .withRule(new FizzBuzzRuleBuilder().withCondition(n -> n % 3 == 0).withMapper(n -> "fizz").build())
                .withDefaultRule(new FizzBuzzRuleBuilder().withCondition(n -> true).withMapper(n -> n.toString()).build())
                .build();

        Supplier<Integer> integerSupplier = new Supplier<Integer>() {

            private Iterator<Integer> ints = IntStream.rangeClosed(1,20).iterator();

            @Override
            public Integer get() {
                return ints.next();
            }
        };


        integerSupplier.get();
        String result = configurableFizzBuzzer.fizzBuzzerize(range1To20);
        assertThat(result).isEqualTo(ROBFRANK_FIZZBUZZ_EXPECTED_RESULT_WITH_RANGE_1_TO_20, result);
    }


    @Test
    void whenRuleAcceptNumber_ThenStringIsReturned() {
        FizzBuzzRule rule = new FizzBuzzRuleBuilder()
                .withCondition(i -> i % 3 == 0)
                .withMapper(n -> "foo")
                .build();
        assertThat(rule.test(3)).isTrue();
        assertThat(rule.apply(3)).isEqualTo("foo");

    }

}
