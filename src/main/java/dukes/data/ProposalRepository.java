package dukes.data;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProposalRepository extends CrudRepository<Proposal, Long>{

    Optional<Proposal> findByNameIgnoreCase(String name);
    List<Proposal> findByClient(Client client);
}