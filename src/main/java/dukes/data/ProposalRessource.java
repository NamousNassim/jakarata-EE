package dukes.data;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
@Path("/Proposals")
public class ProposalRessource {

    @Inject
    private ProposalRepository proposalRepository;

    @Inject 
    private ClientRepository clientRepository;
  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proposal> findAll() {

        return proposalRepository.findAll()
                .toList();
    }
@GET
@Path("/client")
@Produces(MediaType.APPLICATION_JSON)
public List<Proposal> findByClientId(@QueryParam("clientId") int clientId) {
    Client client = clientRepository.findById(clientId)
        .orElseThrow(() -> new WebApplicationException("Client not found with id " + clientId, Response.Status.NOT_FOUND));
    return proposalRepository.findByClient(client);
}
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGreeting(Proposal proposal, @QueryParam("clientId") int clientId) {
        Client client = clientRepository.findById(clientId)
            .orElseThrow(() -> new WebApplicationException("Client not found with id " + clientId, Response.Status.NOT_FOUND));
        proposal.setClient(client);
        Proposal saved = proposalRepository.save(proposal);
        return Response.ok("Proposal Created !").build();
    }

    @PUT
@Path("/{id}")
@Consumes(MediaType.APPLICATION_JSON)
public Response updateProposal(@PathParam("id") Long id, Proposal newProposalData) {
    Proposal updatedProposal = proposalRepository.findById(id)
        .map(proposal -> {
            proposal.setPrice(newProposalData.getPrice());
            proposal.setDescription(newProposalData.getDescription());
            return proposalRepository.save(proposal);
        })
        .orElseThrow(() -> new WebApplicationException("Proposal not found with id " + id, Response.Status.NOT_FOUND));
    return Response.ok("Proposal Updated !").build();
}

@DELETE
@Path("/{id}")
public Response deleteProposal(@PathParam("id") Long id) {
    if (!proposalRepository.existsById(id)) {
        throw new WebApplicationException("Proposal not found with id " + id, Response.Status.NOT_FOUND);
    }
    proposalRepository.deleteById(id);
    return Response.ok("Proposal Deleted !").build();
}

}