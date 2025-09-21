-- Create a sequence
CREATE SEQUENCE appointment_service.ad_id_seq;

-- Alter the pd_id column to use the sequence
ALTER TABLE appointment_service.appointments_details
ALTER COLUMN ad_id SET DEFAULT nextval('appointment_service.ad_id_seq');

-- Set the sequence's ownership to the pd_id column
ALTER SEQUENCE appointment_service.ad_id_seq
OWNED BY appointment_service.appointments_details.ad_id;
