package com.hospital.hospital;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "doctors")
public class Doctor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Name must be at least 3 characters")
    private String name;
    
    @NotBlank(message = "City is required")
    @Size(max = 20, message = "City must be at most 20 characters")
    @Pattern(regexp = "^(Delhi|Noida|Faridabad)$", message = "City must be Delhi, Noida, or Faridabad")
    private String city;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    
    @NotBlank(message = "Phone number is required")
    @Size(min = 10, message = "Phone number must be at least 10 digits")
    @Pattern(regexp = "\\d{10,}", message = "Invalid phone number format")
    private String phoneNumber;
    
    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    // Constructors
    public Doctor() {
        // Default constructor required by JPA
    }

    public Doctor(Long id, String name, String city, String email, String phoneNumber, Speciality speciality) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.speciality = speciality;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
