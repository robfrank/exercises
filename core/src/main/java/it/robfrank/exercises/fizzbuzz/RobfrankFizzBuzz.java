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

public class RobfrankFizzBuzz {

  public String execute(Stream<Integer> numbers) {
    return numbers.map(this::execute).collect(Collectors.joining(" "));
  }

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
