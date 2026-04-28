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

    app = Javalin.create(config -> {
      config.routes.get("/", ctx -> ctx.result("Hello World"));
      config.routes.get("/up", ctx -> ctx.status(200));
      config.routes.apiBuilder(() -> {
        path("/fizzbuzz", () -> path("{range}", () -> get(handler)));
      });

      config.registerPlugin(new OpenApiPlugin(openApiConfig -> openApiConfig.withDocumentationPath("/openapi")));
      config.registerPlugin(new SwaggerPlugin(swaggerConfiguration -> swaggerConfiguration.withDocumentationPath("/openapi")));
    });
  }

  public Javalin getApp() {
    return app;
  }
}
