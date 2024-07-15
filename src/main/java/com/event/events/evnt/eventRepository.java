package com.event.events.evnt;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class eventRepository {



    private List<event> evnt=new ArrayList<>();


    public List<event> findAll(){
        return evnt;
    }

/*normal findById function but it did not handle exceptions where the id is not found
    public Run findById(Integer id){
        return runs.stream()
                .filter(evt -> evt.id()==id)
                .findFirst()
                .get();
    }
    */

    //to catch the error whene the id is not found

    Optional<event> findById(Integer id) {
        return evnt.stream()
                .filter(evt -> evt.id() == id)
                .findFirst();
    }




    //add
    public void create (event run){
        evnt.add(run);
    }

    //modify
    public void update (event run , Integer id){
        Optional <event> o= findById(id);
        if(o.isPresent()){
            evnt.set(evnt.indexOf(o.get()),run);
        }
    }

    //delete
    public void delete(Integer id){
        evnt.removeIf(d->d.id().equals(id));
    }

    @PostConstruct
    private void init(){
        evnt.add(new event(1,2,"ldbndfvesfdds c","fatal", LocalDateTime.now(),LocalDateTime.now().plus(1, ChronoUnit.HOURS),"tunis","event for maraton"));
        evnt.add(new event(7,2,"ldbndfvesfdds c","fatal", LocalDateTime.now(),LocalDateTime.now().plus(1, ChronoUnit.HOURS),"tunis","event for maraton"));

        evnt.add(new event(2,2,"ldbndfvesfdds c","fatal", LocalDateTime.now(),LocalDateTime.now().plus(1, ChronoUnit.HOURS),"tunis","event for maraton"));

        evnt.add(new event(4,2,"ldbndfvesfdds c","fatal", LocalDateTime.now(),LocalDateTime.now().plus(1, ChronoUnit.HOURS),"tunis","event for maraton"));

        evnt.add(new event(3,2,"ldbndfvesfdds c","fatal", LocalDateTime.now(),LocalDateTime.now().plus(1, ChronoUnit.HOURS),"tunis","event for maraton"));

        evnt.add(new event(5,2,"ldbndfvesfdds c","fatal", LocalDateTime.now(),LocalDateTime.now().plus(1, ChronoUnit.HOURS),"tunis","event for maraton"));


    }

}

