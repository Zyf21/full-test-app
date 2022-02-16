CREATE TABLE IF NOT EXISTS record
(
    id        BIGSERIAL PRIMARY KEY NOT NULL,
    agree     BOOLEAN               NOT NULL,
    user_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS sector_name
(
    id        BIGSERIAL PRIMARY KEY NOT NULL,
    name      VARCHAR(255)          NOT NULL,
    record_id BIGINT
        CONSTRAINT fk_record_id REFERENCES record
);