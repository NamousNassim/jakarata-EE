package dukes.data;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/Projects")
public class ProjectRessource {

    @Inject
    private ProjectRepository projectRepository;
    @Inject 
    private FreelancerRepository freelancerRepository;
  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> findAll() {

        return projectRepository.findAll()
                .toList();
    }

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGreeting(Project u) {
        Freelancer freelancer = freelancerRepository.findById(u.getFreelancer().getFreelancerId())
            .orElseThrow(() -> new WebApplicationException("Freelancer not found with id " + u.getFreelancer().getFreelancerId(), Response.Status.NOT_FOUND));
        u.setFreelancer(freelancer);
        Project saved = projectRepository.save(u);
        return Response.ok("Project Created !: " ).build();
    }
    @Path("/freelancer/{freelancerId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> findByFreelancerId(@PathParam("freelancerId") Long freelancerId) {
        return projectRepository.findByFreelancerId(freelancerId);
    }

}