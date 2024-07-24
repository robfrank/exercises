package it.robfrank.exercises.fizzbuzz;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchTests;
import it.robfrank.exercises.fizzbuzz.archtests.CommonArchTest;

@AnalyzeClasses(packages = "it.robfrank.exercises.fizzbuzz")
public class FizzBuzzArchTest {

  @ArchTest
  static final ArchTests commonRules = ArchTests.in(CommonArchTest.class);
}
