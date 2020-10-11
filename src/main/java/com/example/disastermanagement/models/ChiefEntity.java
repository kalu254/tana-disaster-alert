package com.example.disastermanagement.models;

import javax.persistence.*;

@Table(name = "chief_table")
@Entity
public class ChiefEntity {

    @Id
    @Column(name = "chief_service_id")
    private String id;
    @Column
    private String f_name;
    @Column
    private String l_name;
    @Column
    private String email_address;
    @Column
    private String location;
    @Column
    private int phone_number;
    @Column
    private String password;

    public ChiefEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Chief{" +
            "chief_service_id='" + id + '\'' +
            ", fname='" + f_name + '\'' +
            ", lname='" + l_name + '\'' +
            ", email_address='" + email_address + '\'' +
            ", location='" + location + '\'' +
            ", phone_number=" + phone_number +
            ", password='" + password + '\'' +
            '}';
    }
}
