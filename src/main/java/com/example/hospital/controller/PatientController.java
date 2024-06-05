package com.example.hospital.controller;

import com.example.hospital.persistance.domain.Patient;
import com.example.hospital.service.PatientService;
import com.example.hospital.transport.request.CreatePatientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(path = "/patients")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping(path = "/patient")
    public List<Patient> getPatientsByIds(@RequestParam List<Long> ids){
        return patientService.getPatientsByIds(ids);
    }

    @GetMapping(path = "/patient/{id}")
    public Patient getPatientById(@PathVariable(name = "id") Long id){
        return patientService.getPatient(id);
    }

    @DeleteMapping(path = "/patient/{id}")
    public void deletePatient(@PathVariable(value = "id") Long id){
        patientService.deletePatient(id);
    }
    @PostMapping(path = "/patient")
    public Patient createPatient(@RequestBody CreatePatientRequest request){
        return patientService.createPatient(request);
    }
    

}
