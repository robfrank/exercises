package it.robfrank.exercises.fizzbuzz;

import org.junit.jupiter.api.Test;

import java.util.List;

import static it.robfrank.exercises.fizzbuzz.FizzBuzzTest.ROBFRANK_FIZZBUZZ_EXPECTED_RESULT_WITH_RANGE_1_TO_20;
import static it.robfrank.exercises.fizzbuzz.FizzBuzzTest.range1To20;
import static org.assertj.core.api.Assertions.assertThat;

class RuleBasedFizzBuzzerTest {

    @Test
    void whenRunningConfigurableFizzBuzz_ThenReturnExpectedOutput() {

        RuleBasedFizzBuzzer configurableFizzBuzzer = new ConfigurableFizzBuzzerBuilder()
                .withRules(List.of(
                        new Rule.RuleBuilder().withCondition(n -> n.toString().contains("3")).withMapper(n -> "robfrank").createRule(),
                        new Rule.RuleBuilder().withCondition(n -> n % 15 == 0).withMapper(n -> "fizzbuzz").createRule()))
                .withRule(new Rule.RuleBuilder().withCondition(n -> n % 5 == 0).withMapper(n -> "buzz").createRule())
                .withRule(new Rule.RuleBuilder().withCondition(n -> n % 3 == 0).withMapper(n -> "fizz").createRule())
                .withDefaultRule(new Rule.RuleBuilder().withCondition(n -> true).withMapper(n -> n.toString()).createRule())
                .createConfigurableFizzBuzzer();
        String result = configurableFizzBuzzer.fizzBuzzerize(range1To20);
        assertThat(result).isEqualTo(ROBFRANK_FIZZBUZZ_EXPECTED_RESULT_WITH_RANGE_1_TO_20, result);
    }


    @Test
    void whenRuleAcceptNumber_ThenStringIsReturned() {
        Rule rule = new Rule.RuleBuilder()
                .withCondition(i -> i % 3 == 0)
                .withMapper(n -> "foo")
                .createRule();
        assertThat(rule.test(3)).isTrue();
        assertThat(rule.apply(3)).isEqualTo("foo");

    }

}
