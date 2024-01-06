package dukes.data;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.Optional;

@Repository
public interface FreelancerRepository extends CrudRepository<Freelancer, Long>{

    Optional<Freelancer> findByNameIgnoreCase(String name);

    Optional<Freelancer> findByUser(User user);

    Optional<Freelancer> findById(int id);
    Optional<Freelancer> findByUser_Id(int userId);
}