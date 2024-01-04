package dukes.data;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/Conversations")
public class ConversationRessource {

    @Inject
    private ConversationRepository conversationRepository;

  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Conversation> findAll() {

        return conversationRepository.findAll()
                .toList();
    }

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGreeting(Conversation u) {

      Conversation saved = conversationRepository.save(u);
        return Response.ok("Conversation Created !: " ).build();
    }
}