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

public class FizzBuzzRule implements Predicate<Integer>, Function<Integer, String> {

    private final Predicate<Integer> condition;
    private final Function<Integer, String> mapper;

    private FizzBuzzRule(Predicate<Integer> condition, Function<Integer, String> mapper) {
        this.condition = condition;
        this.mapper = mapper;
    }


    @Override
    public boolean test(Integer number) {
        return condition.test(number);
    }

    @Override
    public String apply(Integer number) {
        return mapper.apply(number);
    }

    public static FizzBuzzRuleBuilder builder() {
        return new FizzBuzzRuleBuilder();
    }

    public static class FizzBuzzRuleBuilder {
        private Predicate<Integer> condition;
        private Function<Integer, String> mapper;

        private FizzBuzzRuleBuilder() {
        }

        public FizzBuzzRuleBuilder withCondition(Predicate<Integer> condition) {
            this.condition = condition;
            return this;
        }

        public FizzBuzzRuleBuilder withMapper(Function<Integer, String> mapper) {
            this.mapper = mapper;
            return this;
        }

        public FizzBuzzRule build() {
            return new FizzBuzzRule(condition, mapper);
        }
    }
}
