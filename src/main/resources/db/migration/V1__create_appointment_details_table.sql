CREATE SCHEMA IF NOT EXISTS appointment_service;

CREATE TABLE appointment_service.appointments_details (
    ad_id BIGSERIAL PRIMARY KEY,
    ad_pd_id BIGINT NOT NULL,
    ad_dd_id BIGINT NOT NULL,
    ad_appointment_date DATE NOT NULL,
    ad_start_time TIME NOT NULL,
    ad_end_time TIME,
    ad_status VARCHAR(20) NOT NULL DEFAULT 'SCHEDULED',
    ad_notes TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);
