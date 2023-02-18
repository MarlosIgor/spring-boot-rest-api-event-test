package br.com.event.service;

import br.com.event.entity.ParticipantEntity;
import br.com.event.exception.NotFoundException;
import br.com.event.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public List<ParticipantEntity> findAll() {
        return participantRepository.findAll();
    }

    public ParticipantEntity findById(Long id) {
        return participantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Event not found with ID " + id));
    }

    public void save(ParticipantEntity participantEntity) {
        participantRepository.save(participantEntity);
    }

    public void update(Long id, ParticipantEntity participantEntity) {
        ParticipantEntity existingEvent = participantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Event not found with ID " + id));

        existingEvent.setName(participantEntity.getName());
        existingEvent.setCpf(participantEntity.getCpf());
        existingEvent.setEmail(participantEntity.getEmail());
        existingEvent.setAddress(participantEntity.getAddress());
        existingEvent.setNeighborhood(participantEntity.getNeighborhood());
        existingEvent.setPostalCode(participantEntity.getPostalCode());
        existingEvent.setPhoneNumber(participantEntity.getPhoneNumber());
        existingEvent.setWhatsapp(participantEntity.getWhatsapp());

        participantRepository.save(existingEvent);
    }

    public void deleteById(Long id) {

        ParticipantEntity participant = participantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Event not found with ID " + id));
        participantRepository.deleteById(id);
    }

}