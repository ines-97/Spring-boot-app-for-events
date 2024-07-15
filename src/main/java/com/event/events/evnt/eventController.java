package com.event.events.evnt;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/event")//global url

public class eventController {

    private final eventRepository revent; // call to the repository

    public eventController(eventRepository revent){
        this.revent= revent;
    } //constructor


    //get
    @GetMapping("/All") //url
    public List<event> findAll(){
        return revent.findAll();
    }
/*dynamic search for id
    @GetMapping("/{id}") //url
    public Run findById(@PathVariable Integer id){
        return runRepository.findById(id);
    }
    */


    // dynamic search for id with the keyword Optional
    @GetMapping("/{id}") //url
    public event findById(@PathVariable Integer id){
        Optional<event> o= revent.findById(id);
        if(o.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return o.get();
    }
    //post-add
    // @ResponseStatus(HttpStatus.CREATED)//- 200 created- montione the status of http request(created....)
    @PostMapping("")//url
    public void create (@Valid @RequestBody event run){ //@valid to use validation dependancy from Run record
        revent.create(run);
    }
    //put-modify
    //@ResponseStatus(HttpStatus.NO_CONTENT)//200 no content
    @PutMapping("m/{id}")
    public void update (@RequestBody event run,@PathVariable Integer id){
        revent.update(run,id);
    }

    //delete-delete
    //@ResponseStatus(HttpStatus.NO_CONTENT)//200 no content
    @DeleteMapping("d/{id}")
    public void delete (@PathVariable Integer id){
        revent.delete(id);
    }
}