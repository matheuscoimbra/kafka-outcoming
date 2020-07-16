package com.kafka.outcoming;



import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.logging.Logger;

@ApplicationScoped
public class MessageService {
    private static final Logger LOGGER = Logger.getLogger(com.kafka.outcoming.MessageService.class.getName());

    @Inject
    @Channel("generated-price")
    Emitter<JsonObject> emitter;

    public void sendMessage(String text) {
        LOGGER.info("Sending message: " + text);
        JsonObject json = new JsonObject();
        json.put("message", text);
        emitter.send(json);
    }
}
