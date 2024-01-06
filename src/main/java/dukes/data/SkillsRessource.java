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

    @Inject 
    FreelancerRepository FreelancerRepository;
  
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
    @POST
    @Path("/freelancer/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSkillToFreelancer(@PathParam("id") int id, Skills newSkill) {
        Freelancer freelancer = FreelancerRepository.findById(id).orElseThrow(() -> new NotFoundException("Freelancer with id " + id + " not found"));
        newSkill.setFreelancer(freelancer);
        skillsRepository.save(newSkill);
        return Response.status(Response.Status.CREATED).build();
    }
    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGreeting(Skills u) {

      Skills saved = skillsRepository.save(u);
        return Response.ok("Skill Created !: " ).build();
    }
@DELETE
@Path("/{id}")
public Response deleteSkill(@PathParam("id") long id) {
    if (!skillsRepository.existsById(id)) {
        throw new WebApplicationException("Skill not found with id " + id, Response.Status.NOT_FOUND);
    }
    skillsRepository.deleteById(id);
    return Response.ok("Skill Deleted !").build();

    }
}