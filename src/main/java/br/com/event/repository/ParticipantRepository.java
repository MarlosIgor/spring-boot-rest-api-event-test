package br.com.event.repository;

import br.com.event.entity.ParticipantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipantRepository extends CrudRepository<ParticipantEntity, Long> {

    List<ParticipantEntity> findAll();

    Optional<ParticipantEntity> findById(Long id);
    
}
