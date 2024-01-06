package dukes.data;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/users")
public class UserResource {

    @Inject
    private UserRepository userRepository;

    @Inject
    private FreelancerRepository freelancerRepository;

    @Inject
    private ClientRepository clientRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> findAll() {
        return userRepository.findAll().toList();
    }

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {
        User savedUser = userRepository.save(user);

        if ("freelancer".equals(user.getRole())) {
            Freelancer freelancer = new Freelancer();
            freelancer.setUser(savedUser);
            freelancerRepository.save(freelancer);
        }

        if ("client".equals(user.getRole())) {
            Client client = new Client();
            client.setUser(savedUser);
            clientRepository.save(client);
        }

        return Response.ok("User Created !: " ).build();
    }

    @GET
    @Path("/freelancer/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Freelancer> getFreelancerByUserId(@PathParam("userId") Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent() && "freelancer".equals(user.get().getRole())) {
            return freelancerRepository.findByUser(user.get());
        }
        throw new NotFoundException("Freelancer with user id " + userId + " not found");
    }

    @GET
@Path("/client/{userId}")
@Produces(MediaType.APPLICATION_JSON)
public Optional<Client> getClientByUserId(@PathParam("userId") Long userId) {
    Optional<User> user = userRepository.findById(userId);
    if (user.isPresent() && "client".equals(user.get().getRole())) {
        return clientRepository.findByUser(user.get());
    }
    throw new NotFoundException("Client with user id " + userId + " not found");
}
}