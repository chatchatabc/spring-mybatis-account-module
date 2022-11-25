INSERT INTO users
(id,
 username,
 password,
 email,
 dateAt,
 lastLogin
)
VALUES(
          DEFAULT,
          'admin',
          '123',
          'admin@email.com',
          localtimestamp,
          localtimestamp
      )