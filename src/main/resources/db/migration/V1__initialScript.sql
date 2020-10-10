CREATE TABLE IF NOT EXISTS chief_table (

   chief_service_id    varchar(20)
                      constraint chief_table_pk
                          PRIMARY KEY,
   f_name text not null,
   l_name text not null,
   email_address varchar(50) not null,
   location text not null,
   phone_number int not null,
   password varchar(300) not null
);

CREATE TABLE IF NOT EXISTS commissioner_table (

  commissioner_service_id  varchar(20)
                      constraint commissioner_table_pk
                      PRIMARY KEY,
  f_name text not null,
  l_name text not null,
  email_address varchar(50) not null,
  county text not null,
  phone_number int not null,
  password varchar(300) not null
);

CREATE TABLE IF NOT EXISTS disaster_table (

  disaster_id    serial
           constraint disaster_table_pk
           PRIMARY KEY,
  disaster_type text not null,
  disaster_description text not null,
  date_reported date not null,
  village text not null,
  chief_service_id varchar
          constraint disaster_table_chief_table_id_fk
              references chief_table,
  disaster_img_url_one varchar(100) not null,
  disaster_img_url_two varchar(100),
  disaster_img_url_three varchar(100),
  disaster_img_url_four varchar(100)

);

CREATE TABLE IF NOT EXISTS affected_unit_table (

   id_no   int
          constraint affected_unit_table_pk
          PRIMARY KEY,
   f_name text not null,
   l_name text not null,
   village text not null,
   occupants int   not null,
   p_l_w_d int not null,
   children_under_five int not null,
   chief_service_id varchar
             constraint affected_unit_table_chief_table_id_fk
                 references chief_table,
   disaster_id int
         constraint affected_unit_table_disaster_table_id_fk
                 references disaster_table

);
