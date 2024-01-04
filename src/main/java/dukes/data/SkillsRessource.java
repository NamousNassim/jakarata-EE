package dukes.data;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/Skills")
public class SkillsRessource {

    @Inject
    private SkillsRepository skillsRepository;

  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Skills> findAll() {

        return skillsRepository.findAll()
                .toList();
    }

    @GET
    @Path("/freelancer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Skills> findByFreelancerId(@PathParam("id") int id) {
        return skillsRepository.findByFreelancerId(id);
    }

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGreeting(Skills u) {

      Skills saved = skillsRepository.save(u);
        return Response.ok("Skill Created !: " ).build();
    }
}