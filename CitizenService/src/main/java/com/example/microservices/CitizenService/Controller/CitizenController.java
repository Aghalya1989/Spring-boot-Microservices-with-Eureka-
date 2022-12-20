package com.example.microservices.CitizenService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.CitizenService.Entity.Citizen;
import com.example.microservices.CitizenService.Repository.CitizenRepo;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	@Autowired
	private CitizenRepo citizenrepo;
	@RequestMapping("/test")
	public ResponseEntity<String> test()
	{
	
		return new ResponseEntity<>("Hello",org.springframework.http.HttpStatus.OK);
	}
	
	@RequestMapping(path= "/id/{id}")
	public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id)
	{
	
		List<Citizen> listCitizen = citizenrepo.findByVaccinationCenterId(id);
		return new ResponseEntity<>(listCitizen,org.springframework.http.HttpStatus.OK);
	}

	@PostMapping(path= "/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newcitizen)
	{
	
		Citizen  citizen= citizenrepo.save(newcitizen);
		return new ResponseEntity<>(citizen,org.springframework.http.HttpStatus.OK);
	}


}
