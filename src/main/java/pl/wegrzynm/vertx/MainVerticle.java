package pl.wegrzynm.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() {
        Router router = Router.router(vertx);
        router.get("/api/hello").handler(ctx -> {
            ctx.request().response().end("Hello world");
        });
        router.get("/api/hello/:name").handler(ctx -> {
            String name = ctx.pathParam("name");
            ctx.request().response().end("Hello world " + name);
        });
        vertx.createHttpServer().requestHandler(router).listen(8081);
    }

}
