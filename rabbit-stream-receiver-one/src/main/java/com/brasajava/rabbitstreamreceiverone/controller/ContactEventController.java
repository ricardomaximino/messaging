package com.brasajava.rabbitstreamreceiverone.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brasajava.rabbitstreamreceiverone.domain.Chart;
import com.brasajava.rabbitstreamreceiverone.domain.ContactEvent;
import com.brasajava.rabbitstreamreceiverone.repository.ContactEventRepository;

@RestController
@CrossOrigin(origins = "*")
public class ContactEventController {

	@Autowired
	private ContactEventRepository repository;

	@GetMapping("/event")
	public ResponseEntity<List<ContactEvent>> findAll() {
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/event", params = "created")
	public ResponseEntity<List<ContactEvent>> created() {
		return new ResponseEntity<>(repository.findByType("01"), HttpStatus.OK);
	}

	@GetMapping(value = "/event", params = "saved")
	public ResponseEntity<List<ContactEvent>> saved() {
		return new ResponseEntity<>(repository.findByType("02"), HttpStatus.OK);
	}

	@GetMapping(value = "/event", params = "not-saved")
	public ResponseEntity<List<ContactEvent>> notSaved() {
		return new ResponseEntity<>(repository.findByType("03"), HttpStatus.OK);
	}

	@GetMapping(value = "/event", params = "updated")
	public ResponseEntity<List<ContactEvent>> updated() {
		return new ResponseEntity<>(repository.findByType("04"), HttpStatus.OK);
	}

	@GetMapping(value = "/event", params = "deleted")
	public ResponseEntity<List<ContactEvent>> deleted() {
		return new ResponseEntity<>(repository.findByType("05"), HttpStatus.OK);
	}
}
