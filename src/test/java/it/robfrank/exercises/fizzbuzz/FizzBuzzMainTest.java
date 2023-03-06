package it.robfrank.exercises.fizzbuzz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzMainTest {

    private ByteArrayOutputStream out;

    @BeforeEach
    void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }


    @AfterEach
    void tearDown() {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

    @Test
    public void testMain() {
        FizzBuzzMain.main(new String[]{"20"});

        assertThat(out.toString()).isEqualTo("""
                range = 20
                fizzBuzzrized = 1 2 robfrank 4 buzz fizz 7 8 fizz buzz 11 fizz robfrank 14 fizzbuzz 16 17 fizz 19 buzz
                """);
    }
}
