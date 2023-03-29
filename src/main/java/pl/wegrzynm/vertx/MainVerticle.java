package pl.wegrzynm.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() {
        vertx.deployVerticle(new HelloVerticle());
        Router router = Router.router(vertx);
        router.get("/api/hello").handler(this::helloVertx);
        router.get("/api/hello/:name").handler(this::helloName);
        vertx.createHttpServer().requestHandler(router).listen(8080);
    }

    void helloVertx(RoutingContext ctx) {
        vertx.eventBus().request("hello.vertx.addr","", reply -> {
            ctx.request().response().end(reply.result().body().toString());
        });
    }

    void helloName(RoutingContext ctx) {
        String name = ctx.pathParam("name");
        vertx.eventBus().request("hello.name.addr",name, reply -> {
            ctx.request().response().end(reply.result().body().toString());
        });
    }

}
