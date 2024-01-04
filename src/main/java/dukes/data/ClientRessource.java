package dukes.data;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/Clients")
public class ClientRessource {

    @Inject
    private ClientRepository clientRepository;

  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> findAll() {

        return clientRepository.findAll()
                .toList();
    }

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGreeting(Client u) {

      Client saved = clientRepository.save(u);
        return Response.ok("Client Created !: " ).build();
    }
}