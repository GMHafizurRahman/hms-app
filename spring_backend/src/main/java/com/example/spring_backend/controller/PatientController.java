package com.example.spring_backend.controller;

import com.example.spring_backend.exception.ResourceNotFoundException;
import com.example.spring_backend.model.Patient;
import com.example.spring_backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/v1/")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    //get all patients
    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
    //add a patient
    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/patients/")
    public Patient addPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }

    //get patient by Id
    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not exit in the list" + id));

        return ResponseEntity.ok(patient);
    }

    //Update patient rest api
    @CrossOrigin(origins = "http://localhost:4200/")
    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id,@RequestBody Patient patientDetails){

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not exit in the list" + id));

        patient.setPatientName(patientDetails.getPatientName());
        patient.setPgender(patientDetails.getPgender());
        patient.setPage(patientDetails.getPage());
        patient.setDob(patientDetails.getDob());
        patient.setPhoneNumber(patientDetails.getPhoneNumber());
        patient.setEmailId(patientDetails.getEmailId());
        patient.setPaddress(patientDetails.getPaddress());
        patient.setPphoto(patientDetails.getPphoto());

        Patient updatedPatient = patientRepository.save(patient);

        return ResponseEntity.ok(updatedPatient);
    }

    //Delete patient from list
    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Long id){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not exit in the list" + id));

        patientRepository.delete(patient);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return  ResponseEntity.ok(response);
    }



}
