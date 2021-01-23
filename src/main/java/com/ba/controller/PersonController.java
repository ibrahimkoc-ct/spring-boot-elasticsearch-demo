package com.ba.controller;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ba.entity.Person;
import com.ba.repository.PersonRepository;


@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonRepository repository;
	
	
	@PostConstruct
	public void init() {
		Person person = new Person();
		person.setId("KK1");
		person.setAddress("test");
		person.setName("ibrahim");
		person.setLastname("koc");
		person.setDate(Calendar.getInstance().getTime());

		repository.save(person);
	
	}
	
	@GetMapping("/{search}")
	public ResponseEntity<List<Person>> getPerson(@PathVariable String search){
		return ResponseEntity.ok(repository.findByNameLikeOrLastnameLike(search,search));
	}
	@PostMapping()
	public ResponseEntity<Person> addPerson(@RequestBody Person person){
		return ResponseEntity.ok(repository.save(person));
	}

}
