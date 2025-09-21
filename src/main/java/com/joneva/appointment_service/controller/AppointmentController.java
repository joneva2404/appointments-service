package com.joneva.appointment_service.controller;

import com.joneva.appointment_service.dao.AppointmentDetails;
import com.joneva.appointment_service.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public AppointmentDetails bookAppointment(@RequestBody AppointmentDetails appointmentDetails) {
        return appointmentService.bookAppointment(appointmentDetails);
    }

    @GetMapping("/{id}")
    public Optional<AppointmentDetails> getAppointmentByPatientId(@PathVariable Long id) {
        return appointmentService.getAppointmentByPatientId(id);
    }

    @GetMapping
    public List<AppointmentDetails> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PutMapping("/{id}")
    public AppointmentDetails updateAppointment(@PathVariable Long id, @RequestBody AppointmentDetails updatedDetails) {
        return appointmentService.updateAppointment(id, updatedDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }
}
