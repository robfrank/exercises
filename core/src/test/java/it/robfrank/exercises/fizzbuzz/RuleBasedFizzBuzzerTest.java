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

import static it.robfrank.exercises.fizzbuzz.FizzBuzzTest.ROBFRANK_FIZZBUZZ_EXPECTED_RESULT_WITH_RANGE_1_TO_20;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class RuleBasedFizzBuzzerTest {

  final Stream<Integer> range1To20 = IntStream.rangeClosed(1, 20).boxed();

  @Test
  void whenRunningConfigurableFizzBuzz_ThenReturnExpectedOutput() {
    RuleBasedFizzBuzzer configurableFizzBuzzer = RuleBasedFizzBuzzer.builder()
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

    String result = configurableFizzBuzzer.fizzBuzzerize(range1To20);
    assertThat(result).isEqualTo(ROBFRANK_FIZZBUZZ_EXPECTED_RESULT_WITH_RANGE_1_TO_20, result);
  }

  @Test
  void whenRuleAcceptNumber_ThenStringIsReturned() {
    FizzBuzzRule rule = FizzBuzzRule.builder().withCondition(i -> i % 3 == 0).withMapper(n -> "foo").build();
    assertThat(rule.test(3)).isTrue();
    assertThat(rule.apply(3)).isEqualTo("foo");
  }
}
