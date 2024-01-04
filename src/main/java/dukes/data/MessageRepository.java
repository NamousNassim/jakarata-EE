package dukes.data;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{

    Optional<Message> findByNameIgnoreCase(String name);
}
