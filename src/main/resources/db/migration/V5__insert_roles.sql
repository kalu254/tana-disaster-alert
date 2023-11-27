CREATE TABLE IF NOT EXISTS user_roles_table (
   user_id      bigint,
   role_id    int
);

INSERT INTO roles_table(name) VALUES('ADMIN');
INSERT INTO roles_table(name) VALUES('COMMISSIONER');
INSERT INTO roles_table(name) VALUES('CHIEF');
