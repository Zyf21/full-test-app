CREATE TABLE IF NOT EXISTS sector
(
    id        bigserial primary key NOT NULL,
    name      varchar(255)          NOT NULL,
    parent_id bigint
        constraint fk_parent_id references sector
);
