package pl.wegrzynm.vertx;

import io.vertx.core.AbstractVerticle;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() {
        vertx.createHttpServer().requestHandler(req -> {
            req.response().end("hello world");
        }).listen(8080);
    }

}
