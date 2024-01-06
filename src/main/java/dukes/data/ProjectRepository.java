package dukes.data;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

    Optional<Project> findByNameIgnoreCase(String name);
    List<Project> findByFreelancer_Id(Long freelancerId);
    List<Project> findByFreelancerId(Long freelancerId);
}