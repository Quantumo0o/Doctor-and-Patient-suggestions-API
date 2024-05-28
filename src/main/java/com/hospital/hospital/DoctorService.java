package com.hospital.hospital;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id " + id));
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        Doctor doctor = getDoctorById(id);
        doctor.setName(updatedDoctor.getName());
        doctor.setCity(updatedDoctor.getCity());
        doctor.setEmail(updatedDoctor.getEmail());
        doctor.setPhoneNumber(updatedDoctor.getPhoneNumber());
        doctor.setSpeciality(updatedDoctor.getSpeciality());
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

  



    public List<Doctor> getDoctorsByCity(String city) {
        return doctorRepository.findByCity(city);
    }


    // Autowire DoctorRepository here if you need to fetch data from the database
    
    public List<Doctor> getSuggestedDoctors(Symptom symptom, List<Doctor> doctorsInLocation) {
        // Filter doctors based on the symptom
        List<Doctor> suggestedDoctors = new ArrayList<>();
        for (Doctor doctor : doctorsInLocation) {
            if (doctor.getSpeciality() != null && isMatchingSpeciality(symptom, doctor.getSpeciality())) {
                suggestedDoctors.add(doctor);
            }
        }
        return suggestedDoctors;
    }

    private boolean isMatchingSpeciality(Symptom symptom, Speciality speciality) {
        switch (symptom) {
            case Arthritis:
            case Back_Pain:
            case Tissue_Injuries:
                return speciality == Speciality.Orthopedic;
            case Dysmenorrhea:
                return speciality == Speciality.Gynecology;
            case Skin_Infection:
            case Skin_Burn:
                return speciality == Speciality.Dermatology;
            case Ear_Pain:
                return speciality == Speciality.ENT;
            default:
                return false;
        }
    }

    
}
