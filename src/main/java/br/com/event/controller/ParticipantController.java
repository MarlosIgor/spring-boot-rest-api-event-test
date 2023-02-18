package br.com.event.controller;

import br.com.event.entity.ParticipantEntity;
import br.com.event.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/participant")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;


    @GetMapping(value = "/all")
    public ResponseEntity<List<ParticipantEntity>> getAllParticipante() {
        return new ResponseEntity<List<ParticipantEntity>>(participantService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ParticipantEntity> getEventoById(@Validated @PathVariable Long id) {
        return ResponseEntity.ok(participantService.findById(id));
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Validated @RequestBody ParticipantEntity participantEntity){
        participantService.save(participantEntity);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editParticipante(@PathVariable Long id, @Validated  @RequestBody ParticipantEntity participantEntity){
        participantService.update(id, participantEntity);

    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteId(@Validated @PathVariable("id") Long id){
        participantService.deleteById(id);
    }

}