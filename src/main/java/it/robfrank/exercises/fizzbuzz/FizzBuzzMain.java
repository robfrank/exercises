package it.robfrank.exercises.fizzbuzz;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "fizzbuzz",
        mixinStandardHelpOptions = true,
        version = "the fizzvuzz",
        description = "Fizzbuzzzzzz")
public class FizzBuzzMain implements Callable<Integer> {

    @Option(names = {"-r", "--range"}, description = "range number")
    private Integer range = 20;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new FizzBuzzMain()).execute(args);
//        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("range = " + range);

        RuleBasedFizzBuzzer configurableFizzBuzzer = RuleBasedFizzBuzzer.builder()
                .withRules(List.of(
                        FizzBuzzRule.builder().withCondition(n -> n.toString().contains("3")).withMapper(n -> "robfrank").build(),
                        FizzBuzzRule.builder().withCondition(n -> n % 15 == 0).withMapper(n -> "fizzbuzz").build()))
                .withRule(FizzBuzzRule.builder().withCondition(n -> n % 5 == 0).withMapper(n -> "buzz").build())
                .withRule(FizzBuzzRule.builder().withCondition(n -> n % 3 == 0).withMapper(n -> "fizz").build())
                .withDefaultRule(FizzBuzzRule.builder().withCondition(n -> true).withMapper(n -> n.toString()).build())
                .build();

        String fizzBuzzerized = configurableFizzBuzzer.fizzBuzzerize(IntStream.rangeClosed(1, range).boxed());

        System.out.println("fizzBuzzrized = " + fizzBuzzerized);
        return 0;
    }
}
