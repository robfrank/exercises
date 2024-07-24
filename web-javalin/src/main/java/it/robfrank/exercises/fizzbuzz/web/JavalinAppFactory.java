package it.robfrank.exercises.fizzbuzz.web;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;

import io.javalin.Javalin;
import io.javalin.openapi.plugin.OpenApiPlugin;
import io.javalin.openapi.plugin.swagger.SwaggerPlugin;

public class JavalinAppFactory {

  private final Javalin app;

  public JavalinAppFactory() {
    var handler = new FizzBuzzHandler();

    app =
      Javalin.create(config -> {
        config.router.apiBuilder(() -> {
          get("/", ctx -> ctx.result("Hello World"));
          path("/fizzbuzz", () -> path("{range}", () -> get(handler)));
        });

        config.registerPlugin(new OpenApiPlugin(openApiConfig -> openApiConfig.withDocumentationPath("/openapi")));

        config.registerPlugin(new SwaggerPlugin(swaggerConfiguration -> swaggerConfiguration.setDocumentationPath("/openapi")));
      });
  }

  public Javalin getApp() {
    return app;
  }
}
