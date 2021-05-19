package com.pluralsight.controllers;

import com.pluralsight.models.Session;
import com.pluralsight.repos.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //maps to 201 in the HTTP world. As in Spring it returns 200 by default.
    public Session create(@RequestBody final Session session){
        //save and flush for saving to the db and actually committing the changes
        return sessionRepository.saveAndFlush(session);
    }

//    @DeleteMapping
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//    @RequestMapping(value = "{id}")
    public void delete(@PathVariable Long id){
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session){
        Session sessionToBeUpdated = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, sessionToBeUpdated, "sessionId");
        return sessionRepository.saveAndFlush(sessionToBeUpdated);
    }
}
