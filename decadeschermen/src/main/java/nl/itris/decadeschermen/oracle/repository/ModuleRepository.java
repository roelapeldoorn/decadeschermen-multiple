package nl.itris.decadeschermen.oracle.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.itris.decadeschermen.oracle.domain.DecadeModule;

@Repository
public interface ModuleRepository extends CrudRepository <DecadeModule, Long> {

	@Override
    @Query
    public Iterable<DecadeModule> findAll();
	
	DecadeModule findByRonoption(String ronoption);
	
}
