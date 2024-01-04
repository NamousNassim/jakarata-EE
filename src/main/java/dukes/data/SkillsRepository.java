package dukes.data;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface SkillsRepository extends CrudRepository<Skills, Long>{

    Optional<Skills> findByNameIgnoreCase(String name);

    List<Skills> findByFreelancerId(int id);
}