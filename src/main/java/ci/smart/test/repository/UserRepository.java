package ci.smart.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ci.smart.test.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select e from User e where e.id = :id")
	User findOne(@Param("id")Integer id);

	@Query("select e from User e where e.id = :id")
	User findByNom(@Param("id")Integer id);
}
