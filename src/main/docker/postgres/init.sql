DROP TABLE IF EXISTS users;
CREATE TABLE users (
    ID               SERIAL PRIMARY KEY     NOT NULL,
    NAME             VARCHAR(200)           NULL
);

DROP TABLE IF EXISTS pets;
CREATE TABLE pets (
    ID          SERIAL PRIMARY KEY      NOT NULL,
    USER_ID     INTEGER                 NOT NULL,
    NAME        VARCHAR(200)            NULL
);