DROP TABLE  if exists users;
CREATE TABLE users
(
    id SERIAL PRIMARY KEY,
    username VARCHAR,
    password VARCHAR,
    email VARCHAR,
    roles VARCHAR,
    dateAt timestamp,
    lastLogin timestamp
);
CREATE TABLE roles
(
    id SERIAL PRIMARY KEY,
    rolename VARCHAR
);