package com.joneva.appointment_service.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "appointments_details", schema = "appointment_service")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentDetails {

    @Id
    @Column(name = "ad_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ad_dd_id")
    @JsonProperty("doctor_id")
    private Long doctorId;

    @Column(name = "ad_pd_id")
    @JsonProperty("patient_id")
    private Long patientId;

    @Column(name = "ad_appointment_date")
    @JsonProperty("appointment_date")
    private LocalDate appointmentDate;

    @Column(name = "ad_start_time", nullable = false)
    @JsonProperty("start_time")
    private LocalTime startTime;

    @Column(name = "ad_end_time")
    @JsonProperty("end_time")
    private LocalTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false, name = "ad_status")
    private AppointmentStatus status = AppointmentStatus.SCHEDULED;

    @Column(columnDefinition = "TEXT", name ="ad_notes")
    @JsonProperty("notes")
    private String notes;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
