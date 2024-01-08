-- user_table
create table IF NOT EXISTS app_user(
    id serial primary key,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    email varchar(255) not null,
    username varchar(100) not null
    administration_level varchar(100) not null
    region_level varchar(100) not null,
    region varchar(100) not null,
    phone_number int not null,
    password varchar(100) not null
);

-- disaster_table
CREATE TABLE IF NOT EXISTS disaster_table(
    id SERIAL constraint disaster_table_pk PRIMARY KEY,
    disaster_type text  not  null,
    disaster_description text not  null,
    date_reported date not null,
    village text not null,
    username varchar(100) constraint  disaster_table_user_table_username_fk references user_table,
    disaster_img_url_one  varchar(100) not null,
    disaster_img_url_two varchar(100),
    disaster_img_url_three varchar(100),
    disaster_img_url_four varchar( 100)
    );

-- affected_unit_table
CREATE TABLE IF NOT EXISTS affected_unit_table
(
    id SERIAL constraint affected_unit_table_pk PRIMARY KEY,
    id_no int,
    f_name varchar(50) not  null,
    l_name varchar(50) not null,
    village varchar(50) not null,
    occupants int not null,
    p_l_w_d int not null,
    children_under_five int not null,
    username varchar(50) constraint affected_unit_table_user_table_username_fk references user_table,
    disaster_id int constraint affected_unit_table_disaster_table_id_fk references disaster_table
);

-- user_roles_table
CREATE TABLE IF NOT EXISTS user_roles_table
(
    id SERIAL constraint user_roles_table_pk PRIMARY KEY,
    user_id bigint not  null,
    role_id int
);

-- roles_table
CREATE TABLE IF NOT EXISTS roles_table
(
    id SERIAL constraint roles_table_pk PRIMARYKEY,
    role_name varchar(50)
);


INSERT INTO roles_table(name) VALUES('ADMIN');
INSERT INTO roles_table(name) VALUES('COMMISSIONER');
INSERT INTO roles_table(name) VALUES('CHIEF');
