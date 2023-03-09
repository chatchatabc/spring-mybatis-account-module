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
          'f9ca712cbb0e27fae06ed9e39217d7e2bf234d9c',
          'admin@example.com',
          localtimestamp,
          localtimestamp
      )