package dukes.data;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{

    Optional<Client> findByNameIgnoreCase(String name);
}
