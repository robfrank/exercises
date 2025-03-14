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

import java.util.List;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main entry point for the FizzBuzz application.
 * Demonstrates the use of RuleBasedFizzBuzzer with custom rules configuration.
 */
public class FizzBuzzMain {

  /** Logger for the application */
  static Logger slf4jLogger = LoggerFactory.getLogger(FizzBuzzMain.class);

  /**
   * Executes the FizzBuzz program with a configurable rule-based implementation.
   * Takes a range limit as a command-line argument and processes numbers from 1 to that limit.
   *
   * @param args command line arguments - args[0] should contain the upper limit for the range of numbers
   */
  public static void main(String[] args) {
    Integer range = Integer.valueOf(args[0]);
    slf4jLogger.info("range = {}", range);

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

    String fizzBuzzerized = configurableFizzBuzzer.fizzBuzzerize(IntStream.rangeClosed(1, range).boxed());
    slf4jLogger.info("fizzBuzzrized = {}", fizzBuzzerized);
  }
}
