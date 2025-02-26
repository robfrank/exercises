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

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Extended implementation of the FizzBuzz game with a custom rule.
 * <p>
 * This implementation follows standard FizzBuzz rules but adds an additional rule:
 * - "robfrank" for numbers that contain the digit 3
 * - "fizzbuzz" for numbers divisible by both 3 and 15
 * - "fizz" for numbers divisible by 3
 * - "buzz" for numbers divisible by 5
 * - the number itself for all other cases
 * <p>
 * The rules are evaluated in the order listed above, so the "robfrank" rule takes
 * precedence over the other rules.
 */
public class RobfrankFizzBuzz {

  /**
   * Processes a stream of integers and applies extended FizzBuzz rules to each number.
   *
   * @param numbers a stream of integers to be processed
   * @return a string with space-separated results of applying FizzBuzz rules to each number
   */
  public String execute(Stream<Integer> numbers) {
    return numbers.map(this::execute).collect(Collectors.joining(" "));
  }

  /**
   * Applies extended FizzBuzz rules to a single integer.
   * Rules are evaluated in the following order:
   * 1. If the number contains the digit 3, return "robfrank"
   * 2. If the number is divisible by 15, return "fizzbuzz"
   * 3. If the number is divisible by 3, return "fizz"
   * 4. If the number is divisible by 5, return "buzz"
   * 5. Otherwise, return the number as a string
   *
   * @param number the integer to be processed
   * @return the result of applying the rules to the number
   */
  private String execute(Integer number) {
    return switch (number) {
      case Integer n when n.toString().contains("3") -> "robfrank";
      case Integer n when (n % 15 == 0) -> "fizzbuzz";
      case Integer n when (n % 3 == 0) -> "fizz";
      case Integer n when (n % 5 == 0) -> "buzz";
      default -> number.toString();
    };
  }
}
