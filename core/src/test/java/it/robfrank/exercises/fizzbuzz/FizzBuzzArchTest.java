package it.robfrank.exercises.fizzbuzz;

import static com.tngtech.archunit.library.GeneralCodingRules.*;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchTests;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import it.robfrank.exercises.fizzbuzz.archtests.CommonArchTest;

@AnalyzeClasses(packages = "it.robfrank.exercises.fizzbuzz")
public class FizzBuzzArchTest {

  @ArchTest
  static final ArchTests commonRules = ArchTests.in(CommonArchTest.class);
}
