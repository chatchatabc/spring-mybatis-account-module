DROP TABLE IF EXISTS users;
TABLE users
(
    id int PRIMARY KEY auto_increment,
    username    VARCHAR,
    password   VARCHAR,
    email VARCHAR,
    dateCreated date,
    lastLogin date
);