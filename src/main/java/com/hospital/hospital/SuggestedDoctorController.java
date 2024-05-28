package com.hospital.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suggested-doctors")
public class SuggestedDoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @GetMapping("/suggest")
    public ResponseEntity<?> suggestDoctors(@RequestParam Long patientId) {
        // Get patient details
        Patient patient = patientService.getPatientById(patientId);

        // Check if patient exists
        if (patient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }

        // Get doctors in patient's location
        List<Doctor> doctorsInLocation = doctorService.getDoctorsByCity(patient.getCity());

        // Check if doctors exist in the location
        if (doctorsInLocation.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("We are still waiting to expand to your location");
        }

        // Find doctors with matching speciality based on patient's symptom
        List<Doctor> suggestedDoctors = doctorService.getSuggestedDoctors(patient.getSymptom(), doctorsInLocation);

        // Check if suggested doctors exist
        if (suggestedDoctors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There isn’t any doctor present at your location for your symptom");
        }

        return ResponseEntity.status(HttpStatus.OK).body(suggestedDoctors);
    }
}
