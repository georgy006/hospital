package com.example.hospital.service.impl;

import com.example.hospital.persistance.domain.Doctor;
import com.example.hospital.persistance.domain.Speciality;
import com.example.hospital.persistance.repository.DoctorRepository;
import com.example.hospital.persistance.repository.SpecialityRepository;
import com.example.hospital.service.DoctorService;
import com.example.hospital.transport.request.CreateDoctorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private SpecialityRepository specialityRepository;

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public List<Doctor> getDoctorsByIds(List<Long> ids) {
        return doctorRepository.findAllById(ids);
    }

    @Override
    public Doctor getDoctorById(Long id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if(optionalDoctor.isPresent()){
            return optionalDoctor.get();
        }
        throw new RuntimeException();
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Doctor createDoctor(CreateDoctorRequest request) {
        Doctor doctor = new Doctor();
        doctor.setName(request.getName());

        Optional<Speciality> specialityOptional = specialityRepository.findById(request.getSpecialityId());
        if(specialityOptional.isPresent()){
            doctor.setSpeciality(specialityOptional.get());
        }
        doctor.setSchedule(request.getSchedule());
        doctorRepository.save(doctor);
        return doctor;
    }
}
