DROP TABLE user_table CASCADE;

CREATE TABLE IF NOT EXISTS user_table (
   id          int
                   constraint user_table_pk
                                            PRIMARY KEY,
   username    varchar(20),
   f_name text not null,
   l_name text not null,
   email_address varchar(50) not null,
   administrative_rank varchar(50) not null,
   region_level text not null,
   region text not null,
   phone_number int not null,
   password varchar(300) not null

);
