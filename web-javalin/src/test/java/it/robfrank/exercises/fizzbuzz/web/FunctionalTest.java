package it.robfrank.exercises.fizzbuzz.web;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import okhttp3.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FunctionalTest {

    private Javalin app;

    @BeforeEach
    void setUp() {
        app = new JavalinAppFactory().getApp();
    }

    @Test
    void should_return_fizzbuzz_string() {
        JavalinTest.test(
            app,
            (server, client) -> {
                Response response = client.get("/fizzbuzz/20");
                assertThat(response.code()).isEqualTo(200);
                assertThat(response.body().string()).isEqualTo("1 2 robfrank 4 buzz fizz 7 8 fizz buzz 11 fizz robfrank 14 fizzbuzz 16 17 fizz 19 buzz");
            }
        );
    }

    @Test
    void should_say_hello_world() {
        JavalinTest.test(
            app,
            (server, client) -> {
                Response response = client.get("/");
                assertThat(response.code()).isEqualTo(200);
                assertThat(response.body().string()).isEqualTo("Hello World");
            }
        );
    }
}
