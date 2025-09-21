package com.joneva.appointment_service.service;

import com.joneva.appointment_service.dao.AppointmentDetails;
import com.joneva.appointment_service.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public AppointmentDetails bookAppointment(AppointmentDetails appointmentDetails) {
        return appointmentRepository.save(appointmentDetails);
    }

    // Retrieve an Appointment by ID
    public Optional<AppointmentDetails> getAppointmentByPatientId(Long id) {
        return appointmentRepository.findByPatientId(id);
    }

    // Retrieve All Appointments
    public List<AppointmentDetails> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Update an Appointment
    public AppointmentDetails updateAppointment(Long id, AppointmentDetails updatedDetails) {
        return appointmentRepository.findById(id)
                .map(existingAppointment -> {
                    existingAppointment.setDoctorId(updatedDetails.getDoctorId());
                    existingAppointment.setPatientId(updatedDetails.getPatientId());
                    existingAppointment.setAppointmentDate(updatedDetails.getAppointmentDate());
                    existingAppointment.setStartTime(updatedDetails.getStartTime());
                    existingAppointment.setEndTime(updatedDetails.getEndTime());
                    existingAppointment.setStatus(updatedDetails.getStatus());
                    existingAppointment.setNotes(updatedDetails.getNotes());
                    return appointmentRepository.save(existingAppointment);
                })
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found with id: " + id));
    }

    // Delete an Appointment
    public void deleteAppointment(Long id) {
        if (appointmentRepository.existsById(id)) {
            appointmentRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Appointment not found with id: " + id);
        }
    }
}