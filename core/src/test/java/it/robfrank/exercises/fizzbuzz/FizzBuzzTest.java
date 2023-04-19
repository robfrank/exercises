/*
 * Copyright 2023 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.robfrank.exercises.fizzbuzz;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {

    final Stream<Integer> range1To20 = IntStream.rangeClosed(1, 20).boxed();
    static final String FIZZBUZZ_EXPECTED_RESULT_WITH_RANGE_1_TO_20 = "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz";
    static final String ROBFRANK_FIZZBUZZ_EXPECTED_RESULT_WITH_RANGE_1_TO_20 = "1 2 robfrank 4 buzz fizz 7 8 fizz buzz 11 fizz robfrank 14 fizzbuzz 16 17 fizz 19 buzz";

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
