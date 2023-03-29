package pl.wegrzynm.vertx;

import io.vertx.core.AbstractVerticle;

public class HelloVerticle extends AbstractVerticle {

    @Override public void start() throws Exception {
        vertx.eventBus().consumer("hello.vertx.addr", msg -> {
            msg.reply("Hello world");
        });
        vertx.eventBus().consumer("hello.name.addr", msg -> {
            String name = msg.body().toString();
            msg.reply("Hello world " + name);
        });
    }
}
