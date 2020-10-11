package com.example.disastermanagement.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "commissioner_table")
@Entity
public class CommissionerEntity {

    @Id
    @Column(name = "commissioner_service_id")
    private String id;
    @Column
    private String f_name;
    @Column
    private String l_name;
    @Column
    private String email_address;
    @Column
    private String county;
    @Column
    private int Phone_number;
    @Column
    private String password;

    public CommissionerEntity() {
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public int getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(int phone_number) {
        Phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Commissioner{" +
            "commissioner_service_id='" + id + '\'' +
            ", fname='" + f_name + '\'' +
            ", lname='" + l_name + '\'' +
            ", email_address='" + email_address + '\'' +
            ", county='" + county + '\'' +
            ", Phone_number='" + Phone_number + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
