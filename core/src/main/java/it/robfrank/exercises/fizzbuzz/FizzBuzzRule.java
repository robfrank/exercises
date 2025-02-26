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

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Represents a rule in the FizzBuzz game that determines when a specific transformation
 * should be applied to a number.
 * <p>
 * Each rule consists of:
 * - A condition that determines when the rule applies
 * - A mapper function that transforms the number to a string
 * <p>
 * This class implements both Predicate and Function interfaces to facilitate
 * rule checking and application.
 */
public final class FizzBuzzRule implements Predicate<Integer>, Function<Integer, String> {

  /** The condition that determines when this rule applies */
  private final Predicate<Integer> condition;

  /** The transformation to apply when the condition is met */
  private final Function<Integer, String> mapper;

  /**
   * Private constructor used by the builder.
   *
   * @param condition the predicate that determines when this rule applies
   * @param mapper the function that transforms the number to a string
   */
  private FizzBuzzRule(Predicate<Integer> condition, Function<Integer, String> mapper) {
    this.condition = condition;
    this.mapper = mapper;
  }

  /**
   * Creates a new FizzBuzzRule builder.
   *
   * @return a new FizzBuzzRuleBuilder instance
   */
  public static FizzBuzzRuleBuilder builder() {
    return new FizzBuzzRuleBuilder();
  }

  /**
   * Tests if this rule applies to the given number.
   *
   * @param number the number to test
   * @return true if the rule applies, false otherwise
   */
  @Override
  public boolean test(Integer number) {
    return condition.test(number);
  }

  /**
   * Transforms the number according to this rule.
   *
   * @param number the number to transform
   * @return the transformed string
   */
  @Override
  public String apply(Integer number) {
    return mapper.apply(number);
  }

  /**
   * Builder class for creating FizzBuzzRule instances.
   * Follows the builder pattern to provide a fluent API for rule construction.
   */
  public static final class FizzBuzzRuleBuilder {

    private Predicate<Integer> condition;
    private Function<Integer, String> mapper;

    private FizzBuzzRuleBuilder() {}

    /**
     * Sets the condition for the rule.
     *
     * @param condition the predicate that determines when the rule applies
     * @return this builder instance for method chaining
     */
    public FizzBuzzRuleBuilder withCondition(Predicate<Integer> condition) {
      this.condition = condition;
      return this;
    }

    /**
     * Sets the transformation function for the rule.
     *
     * @param mapper the function that transforms the number to a string
     * @return this builder instance for method chaining
     */
    public FizzBuzzRuleBuilder withMapper(Function<Integer, String> mapper) {
      this.mapper = mapper;
      return this;
    }

    /**
     * Builds a new FizzBuzzRule with the configured condition and mapper.
     *
     * @return a new FizzBuzzRule instance
     */
    public FizzBuzzRule build() {
      return new FizzBuzzRule(condition, mapper);
    }
  }
}
