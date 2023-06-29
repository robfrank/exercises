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
package it.robfrank.exercises.fizzbuzz.cli;

import it.robfrank.exercises.fizzbuzz.FizzBuzzRule;
import it.robfrank.exercises.fizzbuzz.RuleBasedFizzBuzzer;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "fizzbuzz", mixinStandardHelpOptions = true, version = "the fizzvuzz", description = "Fizzbuzzzzzz")
public class FizzBuzzCliMain implements Callable<Integer> {

    @Option(names = {"-r", "--range"}, description = "range number")
    private Integer range = 20;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new FizzBuzzCliMain()).execute(args);
        //        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("range = " + range);

        RuleBasedFizzBuzzer configurableFizzBuzzer = RuleBasedFizzBuzzer
            .builder()
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

        System.out.println("fizzBuzzrized = " + fizzBuzzerized);
        return 0;
    }
}
