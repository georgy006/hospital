package com.example.hospital.service.impl;

import com.example.hospital.persistance.domain.Disease;
import com.example.hospital.persistance.domain.Doctor;
import com.example.hospital.persistance.domain.Patient;
import com.example.hospital.persistance.repository.DiseaseRepository;
import com.example.hospital.persistance.repository.DoctorRepository;
import com.example.hospital.persistance.repository.PatientRepository;
import com.example.hospital.service.PatientService;
import com.example.hospital.transport.request.CreatePatientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DiseaseRepository diseaseRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> getPatientsByIds(List<Long> ids) {
        return patientRepository.findAllById(ids);
    }

    @Override
    public Patient getPatient(Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if(optionalPatient.isPresent()){
           return optionalPatient.get();
        }
        throw new RuntimeException();

    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Patient createPatient(CreatePatientRequest request) {
        Patient patient = new Patient();
        patient.setName(request.getName());
        Optional<Disease> diseaseOptional = diseaseRepository.findById(request.getDiseaseId());
        if(diseaseOptional.isPresent()){
            patient.setDisease(diseaseOptional.get());
        }
        patient.setAge(request.getAge());

        Optional<Doctor> doctorOptional = doctorRepository.findById(request.getDoctorId());
        if(doctorOptional.isPresent()){
            patient.setDoctors(Collections.singletonList(doctorOptional.get()));
        }
        return patientRepository.save(patient);
    }

}
