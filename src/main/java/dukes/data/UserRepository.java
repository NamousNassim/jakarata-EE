package dukes.data;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

    Optional<User> findByNameIgnoreCase(String name);

    Optional<User> findById(Long id);
}