package it.robfrank.exercises.fizzbuzz;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static it.robfrank.exercises.fizzbuzz.FizzBuzzTest.ROBFRANK_FIZZBUZZ_EXPECTED_RESULT_WITH_RANGE_1_TO_20;
import static org.assertj.core.api.Assertions.assertThat;

class RuleBasedFizzBuzzerTest {

    final Stream<Integer> range1To20 = IntStream.rangeClosed(1, 20).boxed();

    @Test
    void whenRunningConfigurableFizzBuzz_ThenReturnExpectedOutput() {

        RuleBasedFizzBuzzer configurableFizzBuzzer = RuleBasedFizzBuzzer.builder()
                .withRules(List.of(
                        FizzBuzzRule.builder()
                                .withCondition(n -> n.toString().contains("3"))
                                .withMapper(n -> "robfrank")
                                .build(),
                        FizzBuzzRule.builder()
                                .withCondition(n -> n % 15 == 0)
                                .withMapper(n -> "fizzbuzz")
                                .build()))
                .withRule(FizzBuzzRule.builder()
                        .withCondition(n -> n % 5 == 0)
                        .withMapper(n -> "buzz")
                        .build())
                .withRule(FizzBuzzRule.builder().withCondition(n -> n % 3 == 0)
                        .withMapper(n -> "fizz")
                        .build())
                .withDefaultRule(FizzBuzzRule.builder().withCondition(n -> true)
                        .withMapper(n -> n.toString())
                        .build())
                .build();

        String result = configurableFizzBuzzer.fizzBuzzerize(range1To20);
        assertThat(result).isEqualTo(ROBFRANK_FIZZBUZZ_EXPECTED_RESULT_WITH_RANGE_1_TO_20, result);
    }


    @Test
    void whenRuleAcceptNumber_ThenStringIsReturned() {
        FizzBuzzRule rule = FizzBuzzRule.builder()
                .withCondition(i -> i % 3 == 0)
                .withMapper(n -> "foo")
                .build();
        assertThat(rule.test(3)).isTrue();
        assertThat(rule.apply(3)).isEqualTo("foo");

    }

}
