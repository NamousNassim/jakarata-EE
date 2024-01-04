package dukes.data;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/Freelancers")
public class FreelancerRessource {

    @Inject
    private FreelancerRepository FreeRepository;

  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Freelancer> findAll() {

        return FreeRepository.findAll()
                .toList();
    }

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGreeting(Freelancer u) {

      Freelancer saved = FreeRepository.save(u);
        return Response.ok("Freelancer Created !: " ).build();
    }
}