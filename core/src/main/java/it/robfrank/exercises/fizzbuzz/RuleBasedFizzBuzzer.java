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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A configurable implementation of FizzBuzz that applies rules in a specified order.
 * <p>
 * This class allows for flexible configuration of FizzBuzz rules through a builder pattern.
 * Rules are evaluated in the order they are added, and the first matching rule is applied.
 * If no rule matches, a default rule is applied.
 */
public final class RuleBasedFizzBuzzer {

  /** The list of rules to apply in order */
  private final List<FizzBuzzRule> rules;

  /** The default rule to apply when no other rule matches */
  private final FizzBuzzRule defaultRule;

  /**
   * Private constructor used by the builder.
   *
   * @param rules the list of rules to apply in order
   * @param defaultRule the default rule to apply when no other rule matches
   */
  private RuleBasedFizzBuzzer(List<FizzBuzzRule> rules, FizzBuzzRule defaultRule) {
    this.rules = rules;
    this.defaultRule = defaultRule;
  }

  /**
   * Creates a new RuleBasedFizzBuzzer builder.
   *
   * @return a new RuleBasedFizzBuzzerBuilder instance
   */
  public static RuleBasedFizzBuzzerBuilder builder() {
    return new RuleBasedFizzBuzzerBuilder();
  }

  /**
   * Processes a stream of integers by applying FizzBuzz rules to each number.
   *
   * @param numbers a stream of integers to be processed
   * @return a space-separated string with the results of applying rules to each number
   */
  public String fizzBuzzerize(Stream<Integer> numbers) {
    return numbers.map(this::fizzBuzzerize).collect(Collectors.joining(" "));
  }

  /**
   * Applies FizzBuzz rules to a single integer.
   * Rules are evaluated in the order they were added to the builder.
   * If no rule matches, the default rule is applied.
   *
   * @param number the integer to be processed
   * @return the result of applying the first matching rule, or the default rule if none match
   */
  public String fizzBuzzerize(Integer number) {
    return rules.stream().filter(p -> p.test(number)).map(f -> f.apply(number)).findFirst().orElse(defaultRule.apply(number));
  }

  /**
   * Builder class for creating RuleBasedFizzBuzzer instances.
   * Follows the builder pattern to provide a fluent API for configuration.
   */
  public static final class RuleBasedFizzBuzzerBuilder {

    private final List<FizzBuzzRule> rules = new ArrayList<>();
    private FizzBuzzRule defaultRule;

    private RuleBasedFizzBuzzerBuilder() {}

    /**
     * Adds multiple rules to the builder.
     *
     * @param rules a list of FizzBuzzRule instances to add
     * @return this builder instance for method chaining
     */
    public RuleBasedFizzBuzzerBuilder withRules(List<FizzBuzzRule> rules) {
      this.rules.addAll(rules);
      return this;
    }

    /**
     * Adds a single rule to the builder.
     *
     * @param rule a FizzBuzzRule instance to add
     * @return this builder instance for method chaining
     */
    public RuleBasedFizzBuzzerBuilder withRule(FizzBuzzRule rule) {
      this.rules.add(rule);
      return this;
    }

    /**
     * Builds a new RuleBasedFizzBuzzer with the configured rules and default rule.
     *
     * @return a new RuleBasedFizzBuzzer instance
     */
    public RuleBasedFizzBuzzer build() {
      return new RuleBasedFizzBuzzer(rules, defaultRule);
    }

    /**
     * Sets the default rule to apply when no other rule matches.
     *
     * @param defaultRule the default FizzBuzzRule to use
     * @return this builder instance for method chaining
     */
    public RuleBasedFizzBuzzerBuilder withDefaultRule(FizzBuzzRule defaultRule) {
      this.defaultRule = defaultRule;
      return this;
    }
  }
}
