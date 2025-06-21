CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE apartments (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    apartment_number BIGINT,
    apartment_block BIGINT,
    total_vacancies INTEGER DEFAULT 8
);

CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR,
    email VARCHAR UNIQUE,
    password VARCHAR,
    type INTEGER,
    phone_number VARCHAR,
    active BOOLEAN DEFAULT TRUE
);

CREATE TABLE maintenances (
     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
     id_student UUID,
     id_confirming_user UUID,
     id_apartment UUID,
     situation VARCHAR,
     material_used VARCHAR,
     activity_description VARCHAR,
     maintenance_date DATE,
     maintenance_time VARCHAR,
     status INTEGER,

     FOREIGN KEY (id_student) REFERENCES usuarios(id) ON DELETE CASCADE,
     FOREIGN KEY (id_confirming_user) REFERENCES usuarios(id) ON DELETE CASCADE,
     FOREIGN KEY (id_apartment) REFERENCES apartamentos(id) ON DELETE CASCADE
);

CREATE TABLE assets (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    id_apartment UUID,
    description VARCHAR,
    condition VARCHAR,
    FOREIGN KEY (id_apartment) REFERENCES apartamentos(id) ON DELETE CASCADE
);

CREATE TABLE vacancies (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    move_in_date DATE,
    move_out_date DATE,
    observations VARCHAR,
    active BOOLEAN,
    id_student UUID,
    id_apartment UUID,
    FOREIGN KEY (id_student) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (id_apartment) REFERENCES apartamentos(id) ON DELETE CASCADE
);

CREATE TABLE inspections (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    id_student UUID,
    id_confirming_user UUID,
    id_apartment UUID,
    inspection_date DATE,
    inspection_time VARCHAR,
    status INTEGER,
    observations VARCHAR,
    FOREIGN KEY (id_student) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (id_confirming_user) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (id_apartment) REFERENCES apartamentos(id) ON DELETE CASCADE
);
