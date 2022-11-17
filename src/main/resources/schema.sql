TABLE users
(
    id SERIAL PRIMARY KEY,
    username    VARCHAR,
    password   VARCHAR,
    email VARCHAR,
    roles VARCHAR
    dateAt timestamp,
    lastLogin timestamp
);