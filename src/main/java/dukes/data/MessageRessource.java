package dukes.data;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/Messages")
public class MessageRessource {

    @Inject
    private MessageRepository messageRepository;

  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> findAll() {

        return messageRepository.findAll()
                .toList();
    }

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGreeting(Message u) {

      Message saved = messageRepository.save(u);
        return Response.ok("Message Created !: " ).build();
    }
}