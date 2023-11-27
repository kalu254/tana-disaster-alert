CREATE TABLE IF NOT EXISTS roles_table (
   id      SERIAL
             constraint roles_table_pk
             PRIMARY KEY,
   name    varchar(20)
);

