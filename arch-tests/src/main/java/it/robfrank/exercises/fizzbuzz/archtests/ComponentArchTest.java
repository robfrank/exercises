package it.robfrank.exercises.fizzbuzz.archtests;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

public class ComponentArchTest {

  @ArchTest
  public static final ArchRule no_web_import_on_cli = noClasses()
    .that()
    .resideInAPackage("it.robfrank.exercises.fizzbuzz.cli")
    .should()
    .dependOnClassesThat()
    .resideInAPackage("it.robfrank.exercises.fizzbuzz.web")
    .because("import of WEB components inside CLI module are forbidden");

  @ArchTest
  public static final ArchRule no_cli_import_on_web = noClasses()
    .that()
    .resideInAPackage("it.robfrank.exercises.fizzbuzz.web")
    .should()
    .dependOnClassesThat()
    .resideInAPackage("it.robfrank.exercises.fizzbuzz.cli")
    .because("import of CLI components inside WEB module are forbidden");
}
