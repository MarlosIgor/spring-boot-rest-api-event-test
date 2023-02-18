package br.com.event.repository;

import br.com.event.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends CrudRepository<EventEntity, Long> {

    List<EventEntity> findAll();

    Optional<EventEntity> findById(Long id);

}
