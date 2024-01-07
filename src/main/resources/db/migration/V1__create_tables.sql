CREATE TABLE IF NOT EXISTS user_table
(

    id
    SERIAL,
    username
    varchar
(
    20
)
    constraint user_table_pk
    PRIMARY KEY,
    f_name text not null,
    l_name text not null,
    email_address varchar
(
    50
) not null,
    administration_level varchar
(
    50
) not null,
    region_level text not null,
    region text not null,
    phone_number int not null,
    password varchar
(
    300
) not null
    );


CREATE TABLE IF NOT EXISTS disaster_table
(

    id
    SERIAL
    constraint
    disaster_table_pk
    PRIMARY
    KEY,
    disaster_type
    text
    not
    null,
    disaster_description
    text
    not
    null,
    date_reported
    date
    not
    null,
    village
    text
    not
    null,
    username
    varchar
    constraint
    disaster_table_user_table_username_fk
    references
    user_table,
    disaster_img_url_one
    varchar
(
    100
) not null,
    disaster_img_url_two varchar
(
    100
),
    disaster_img_url_three varchar
(
    100
),
    disaster_img_url_four varchar
(
    100
)

    );

CREATE TABLE IF NOT EXISTS affected_unit_table
(
    id
    SERIAL,
    id_no
    int
    constraint
    affected_unit_table_pk
    PRIMARY
    KEY,
    f_name
    text
    not
    null,
    l_name
    text
    not
    null,
    village
    text
    not
    null,
    occupants
    int
    not
    null,
    p_l_w_d
    int
    not
    null,
    children_under_five
    int
    not
    null,
    username
    varchar
    constraint
    affected_unit_table_user_table_username_fk
    references
    user_table,
    disaster_id
    int
    constraint
    affected_unit_table_disaster_table_id_fk
    references
    disaster_table

);


CREATE TABLE IF NOT EXISTS user_roles_table
(
    user_id
    bigint,
    role_id
    int
);

CREATE TABLE IF NOT EXISTS roles_table
(
    id
    SERIAL
    constraint
    roles_table_pk
    PRIMARY
    KEY,
    name
    varchar
);




