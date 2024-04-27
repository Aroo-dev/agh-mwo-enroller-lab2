package com.company.enroller.controllers;


import com.company.enroller.model.Meeting;
import com.company.enroller.persistence.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/meetings")
public class MeetingRestController {


    @Autowired
    MeetingService meetingService;


    @RequestMapping
    public ResponseEntity<Collection<Meeting>> getMeeting(){
        Collection<Meeting> allMeetings = meetingService.getAll();

        if (allMeetings != null){

            return ResponseEntity.ok(allMeetings);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Meeting> getById(@PathVariable("id") long id) {
        Meeting meeting = meetingService.getById(id);
        if (meeting != null) {
            return new ResponseEntity<>(meeting, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

