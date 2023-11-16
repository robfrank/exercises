package it.robfrank.exercises.fizzbuzz.web;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;

import io.javalin.Javalin;

public class JavalinAppFactory {

    private final Javalin app;

    public JavalinAppFactory() {
        var handler = new FizzBuzzHandler();

        app = Javalin.create(/*config*/).get("/", ctx -> ctx.result("Hello World"));

        app.routes(() -> {
            path(
                "fizzbuzz",
                () -> {
                    path(
                        "{range}",
                        () -> {
                            get(handler);
                        }
                    );
                }
            );
        });
    }

    public Javalin getApp() {
        return app;
    }
}
