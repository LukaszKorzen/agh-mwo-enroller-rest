package com.company.enroller.controllers;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.company.enroller.model.Meeting;
import com.company.enroller.persistence.MeetingService;

@RestController
@RequestMapping("/meetings")
public class MeetingRestController {



	@Autowired
	MeetingService meetingService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<?> getmeetings() {
		Collection<Meeting> meetings = meetingService.getAll();
		return new ResponseEntity<Collection<Meeting>>(meetings, HttpStatus.OK);
		
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<?> getMeetingById(@PathVariable("id") Long id) {
		     Meeting meeting = meetingService.findByID(id);
		     if (id == null) {
		         return new ResponseEntity(HttpStatus.NOT_FOUND);
		     }
		     return new ResponseEntity<Meeting>(meeting, HttpStatus.OK);
		 }
		
		@RequestMapping(value = "", method = RequestMethod.POST)
		 public ResponseEntity<?> addMeeting(@RequestBody Meeting meeting){
			meetingService.addMeeting(meeting);
			return new ResponseEntity<Meeting>(meeting, HttpStatus.OK);
		}
	}


