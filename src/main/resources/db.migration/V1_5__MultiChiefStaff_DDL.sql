-- MultiChiefStaff, version 1.5, syntax: Postgres

CREATE TABLE position(
position_id BIGSERIAL PRIMARY KEY,
pos_name VARCHAR(80),
pos_code VARCHAR(80)
);

CREATE TABLE employee(
employee_id BIGSERIAL PRIMARY KEY,
first_name VARCHAR(80),
middle_name VARCHAR(80),
last_name VARCHAR(80),
position_id BIGINT REFERENCES "position"(position_id) ON DELETE SET NULL,
doc_link VARCHAR
);