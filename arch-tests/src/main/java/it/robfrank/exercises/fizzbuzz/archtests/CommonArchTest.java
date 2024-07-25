package it.robfrank.exercises.fizzbuzz.archtests;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.GeneralCodingRules.*;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Assertions;

public class CommonArchTest {

  @ArchTest
  public static final ArchRule no_std_out = noClasses()
    .that()
    .resideOutsideOfPackage("it.robfrank.exercises.fizzbuzz.cli")
    .should(ACCESS_STANDARD_STREAMS)
    .because("we want to use a logger instead of System.out, only CLI is allowed to use System.out");

  @ArchTest
  public static final ArchRule no_commons_logging = noClasses()
    .should()
    .accessClassesThat()
    .resideInAPackage("org.apache.commons.logging")
    .because("slf4j should be used instead of apache.commons logger");

  @ArchTest
  public static final ArchRule no_junit_assertions = noClasses()
    .should()
    .accessClassesThat()
    .haveFullyQualifiedName(Assertions.class.getName())
    .because("we want to use AssertJ assertions instead of JUnit assertions");

  @ArchTest
  private final ArchRule no_jodatime = NO_CLASSES_SHOULD_USE_JODATIME;

  @ArchTest
  private final ArchRule no_jul = NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;
}
