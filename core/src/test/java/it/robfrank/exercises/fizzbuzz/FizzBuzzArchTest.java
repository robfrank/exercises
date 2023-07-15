package it.robfrank.exercises.fizzbuzz;

import static com.tngtech.archunit.library.GeneralCodingRules.*;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "it.robfrank.exercises.fizzbuzz")
public class FizzBuzzArchTest {

    @ArchTest
    private final ArchRule no_jodatime = NO_CLASSES_SHOULD_USE_JODATIME;

    @ArchTest
    private final ArchRule no_jul = NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;

    @ArchTest
    private final ArchRule no_standard_streams = NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;

    @ArchTest
    public static final ArchRule no_commons_logging = ArchRuleDefinition
            .noClasses()
            .should()
            .accessClassesThat()
            .resideInAPackage("org.apache.commons.logging")
            .because("slf4j should be used instead of apache.commons logger");
}
