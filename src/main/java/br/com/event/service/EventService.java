package br.com.event.service;

import br.com.event.entity.EventEntity;
import br.com.event.exception.NotFoundException;
import br.com.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<EventEntity> findAll() {
        return eventRepository.findAll();
    }

    public EventEntity findById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Event not found with ID " + id));
    }

    public void save(EventEntity eventEntity) {
        eventRepository.save(eventEntity);
    }

    public void update(Long id, EventEntity eventEntity) {
        EventEntity existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Event not found with ID " + id));

        existingEvent.setName(eventEntity.getName());
        existingEvent.setRegistrantsCount(eventEntity.getRegistrantsCount());

        eventRepository.save(existingEvent);
    }

    public void deleteById(Long id) {

        EventEntity eventEntity = eventRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Event not found with ID " + id));
        eventRepository.deleteById(id);
    }

}