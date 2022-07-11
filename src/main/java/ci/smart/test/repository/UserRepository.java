package ci.smart.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ci.smart.test.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select e from User e where e.id = :id")
	User findOne(@Param("id")Integer id);

	@Query("select e from User e where e.nom = :nom")
	User findByNom(@Param("nom")String nom);
	
	@Query("select e from User e where e.telephone = :telephone")
	User findByTelephone(@Param("telephone")String telephone);
	
	@Query("select e from User e where e.login = :login and e.password = :password ")
	User findByLoginAndPassword(@Param("login")String login, @Param("password")String password );
	
}
