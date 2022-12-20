package com.example.microservices.CitizenService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservices.CitizenService.Entity.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Integer> {
	
public List<Citizen> findByVaccinationCenterId(Integer id);
	
}
