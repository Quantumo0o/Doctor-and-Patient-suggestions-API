package com.hospital.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id " + id));
    }
    

    public Patient addPatient(Patient patient) {
        try {
            return patientRepository.save(patient);
        } catch (DataIntegrityViolationException e) {
            // Handle constraint violation exceptions here
            throw new IllegalArgumentException("Invalid patient data: " + e.getMessage(), e);
        }
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        Patient patient = getPatientById(id);
        patient.setName(updatedPatient.getName());
        patient.setCity(updatedPatient.getCity());
        patient.setEmail(updatedPatient.getEmail());
        patient.setPhoneNumber(updatedPatient.getPhoneNumber());
        patient.setSymptom(updatedPatient.getSymptom());
        try {
            return patientRepository.save(patient);
        } catch (DataIntegrityViolationException e) {
            // Handle constraint violation exceptions here
            throw new IllegalArgumentException("Invalid patient data: " + e.getMessage(), e);
        }
    }

    public void deletePatient(Long id) {
        try {
            patientRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            // Handle constraint violation exceptions here
            throw new IllegalArgumentException("Cannot delete patient with ID " + id + ": " + e.getMessage(), e);
        }
    }
}

