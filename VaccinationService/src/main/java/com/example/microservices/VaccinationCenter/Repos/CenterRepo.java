package com.example.microservices.VaccinationCenter.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservices.VaccinationCenter.Entity.VaccinationCenter;

public interface CenterRepo extends JpaRepository<VaccinationCenter, Integer> {

}
