package nl.itris.decadeschermen.mysql.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.itris.decadeschermen.mysql.domain.DecadeEnvironment;

@Repository
public interface EnvironmentRepository extends CrudRepository <DecadeEnvironment, Long> {

	@Override
    @Query
    public Iterable<DecadeEnvironment> findAll();
	
	DecadeEnvironment findByEnvironmenturl(String environmenturl);
	
}