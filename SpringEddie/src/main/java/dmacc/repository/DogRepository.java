package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long>{
	
}
