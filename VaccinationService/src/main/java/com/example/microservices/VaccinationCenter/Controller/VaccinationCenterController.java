package com.example.microservices.VaccinationCenter.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microservices.VaccinationCenter.Entity.VaccinationCenter;
import com.example.microservices.VaccinationCenter.Repos.CenterRepo;
import com.example.microservices.VaccinationCenter.model.Citizen;
import com.example.microservices.VaccinationCenter.model.RequiredResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {
	
	@Autowired
	private CenterRepo centerRepo;
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(path= "/add")
	public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter vacccent)
	{
	
		VaccinationCenter  vaccicent = centerRepo.save(vacccent);
		return new ResponseEntity<>(vaccicent,org.springframework.http.HttpStatus.OK);
	}

	@GetMapping(path= "/id/{id}")
	@HystrixCommand(fallbackMethod = "handleCitizenDownTime")
	public ResponseEntity<RequiredResponse> getAlldataBasedonCenterId(@PathVariable Integer id)
	{
		RequiredResponse reqResp = new RequiredResponse();
		VaccinationCenter center =centerRepo.findById(id).get();
		reqResp.setCenter(center);
		//connecting to citizenservice
		
		List<Citizen> citizenList =restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
		reqResp.setCitizens(citizenList);
		
		return new ResponseEntity<RequiredResponse>(reqResp,org.springframework.http.HttpStatus.OK);
	}
	//fallBack Method is called when Citizen Service is down
	public ResponseEntity<RequiredResponse> handleCitizenDownTime(@PathVariable Integer id)
	{
		
		RequiredResponse reqResp = new RequiredResponse();
		VaccinationCenter center =centerRepo.findById(id).get();
		reqResp.setCenter(center);
		
		return new ResponseEntity<RequiredResponse>(reqResp,org.springframework.http.HttpStatus.OK);
		
	}

}
