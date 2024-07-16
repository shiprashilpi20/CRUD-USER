package in.learning.Restful_Webservices.repository;

import in.learning.Restful_Webservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}
