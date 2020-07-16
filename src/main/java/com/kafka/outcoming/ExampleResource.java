package com.kafka.outcoming;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExampleResource {

    @Inject
    MessageService messageService;

    @POST
    public Response hello(Mensagem mensagem) {
        messageService.sendMessage(mensagem.getMsg());
        return Response.ok().build();
    }
}