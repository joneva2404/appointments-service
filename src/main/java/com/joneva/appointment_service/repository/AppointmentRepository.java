package com.joneva.appointment_service.repository;

import com.joneva.appointment_service.dao.AppointmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentDetails, Long> {
    Optional<AppointmentDetails> findByPatientId(Long id);
}