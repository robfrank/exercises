package it.robfrank.exercises.fizzbuzz;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {

    final static List<Integer> range1To20 = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
    final static String FIZZBUZZ_EXPECTED_RESULT_WITH_RANGE_1_TO_20 = "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz";
    final static String ROBFRANK_FIZZBUZZ_EXPECTED_RESULT_WITH_RANGE_1_TO_20 = "1 2 robfrank 4 buzz fizz 7 8 fizz buzz 11 fizz robfrank 14 fizzbuzz 16 17 fizz 19 buzz";

    @Test
    void whenRunningFizzBuzz_ThenReturnExpectedOutput() {
        String result = new FizzBuzz().execute(range1To20);
        assertThat(result).isEqualTo(FIZZBUZZ_EXPECTED_RESULT_WITH_RANGE_1_TO_20);
    }

    @Test
    void whenRunningAlfrescoFizzBuzz_ThenReturnExpectedOutput() {
        String result = new RobfrankFizzBuzz().execute(range1To20);
        assertThat(result).isEqualTo(ROBFRANK_FIZZBUZZ_EXPECTED_RESULT_WITH_RANGE_1_TO_20, result);
    }

}
