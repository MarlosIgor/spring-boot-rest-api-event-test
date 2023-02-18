package br.com.event.controller;

import br.com.event.entity.EventEntity;
import br.com.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/event")
public class EventController {

    @Autowired
    private EventService eventService;


    @GetMapping(value = "/all")
    public ResponseEntity<List<EventEntity>> getAllEvento() {
        return new ResponseEntity<List<EventEntity>>(eventService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EventEntity> getEventoById(@Validated @PathVariable Long id){
        return ResponseEntity.ok(eventService.findById(id));
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Validated @RequestBody EventEntity eventEntity){
        eventService.save(eventEntity);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editParticipante(@PathVariable Long id, @Validated  @RequestBody EventEntity eventEntity){
        eventService.update(id, eventEntity);

    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteId(@Validated @PathVariable("id") Long id){
        eventService.deleteById(id);
    }

}
