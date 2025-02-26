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
 * Basic implementation of the FizzBuzz game that processes numbers according to standard rules:
 * - "fizzbuzz" for numbers divisible by both 3 and 15
 * - "fizz" for numbers divisible by 3
 * - "buzz" for numbers divisible by 5
 * - the number itself for all other cases
 */
public class FizzBuzz {

  /**
   * Processes a stream of integers and applies FizzBuzz rules to each number.
   *
   * @param numbers a stream of integers to be processed
   * @return a string with space-separated results of applying FizzBuzz rules to each number
   */
  public String execute(Stream<Integer> numbers) {
    return numbers.map(this::execute).collect(Collectors.joining(" "));
  }

  /**
   * Applies FizzBuzz rules to a single integer.
   *
   * @param number the integer to be processed
   * @return "fizzbuzz" if number is divisible by 15, "fizz" if divisible by 3,
   *         "buzz" if divisible by 5, or the number as a string otherwise
   */
  private String execute(Integer number) {
    return switch (number) {
      case Integer n when (n % 15 == 0) -> "fizzbuzz";
      case Integer n when (n % 3 == 0) -> "fizz";
      case Integer n when (n % 5 == 0) -> "buzz";
      default -> number.toString();
    };
  }
}
