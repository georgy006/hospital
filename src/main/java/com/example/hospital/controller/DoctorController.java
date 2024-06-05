package com.example.hospital.controller;

import com.example.hospital.persistance.domain.Doctor;
import com.example.hospital.persistance.repository.DoctorRepository;
import com.example.hospital.service.DoctorService;
import com.example.hospital.transport.request.CreateDoctorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(path = "/doctors")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping(path = "/doctor")
    public List<Doctor> getDoctorsById(@RequestParam List<Long> ids){
        return doctorService.getDoctorsByIds(ids);
    }

    @GetMapping(path = "/doctor/{id}")
    public Doctor getDoctorById(@PathVariable(name = "id") Long id){
        return doctorService.getDoctorById(id);
    }

    @DeleteMapping(path = "/doctor/{id}")
    public void deleteDoctorById(@PathVariable(name = "id") Long id){
        doctorService.deleteDoctorById(id);
    }

    @PostMapping(path = "/doctor")
    public Doctor createDoctor(@RequestBody CreateDoctorRequest request){
        return doctorService.createDoctor(request);
    }
}
