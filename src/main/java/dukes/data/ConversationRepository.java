package dukes.data;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.Optional;

@Repository
public interface ConversationRepository extends CrudRepository<Conversation, Long>{

    Optional<Conversation> findByNameIgnoreCase(String name);
}
