CREATE SCHEMA IF NOT EXISTS base;

CREATE SEQUENCE base.user_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE base.role_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE base.user_information_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE base."user"
(
    id     BIGINT PRIMARY KEY DEFAULT nextval('base.user_id_seq'),
    name   VARCHAR(120) NOT NULL,
    active BOOLEAN            DEFAULT true
);

CREATE TABLE base.role
(
    id          BIGINT PRIMARY KEY DEFAULT nextval('base.role_id_seq'),
    name        VARCHAR NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE base.user_role
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES base."user" (id),
    FOREIGN KEY (role_id) REFERENCES base.role (id)
);

CREATE TABLE base.user_information
(
    id BIGINT PRIMARY KEY DEFAULT nextval('base.user_information_id_seq'),
    user_id             BIGINT REFERENCES base."user" (id),
    id_external         VARCHAR,
    email               VARCHAR NOT NULL,
    password            VARCHAR(100),
    provider            VARCHAR
);
