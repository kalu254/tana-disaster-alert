package com.example.disastermanagement.models;

import javax.persistence.*;

@Table(name = "user_table")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq", initialValue = 1, allocationSize=1)
    @Column
    private Integer id;
    @Column
    private String username;
    @Column(name = "f_name")
    private String fName;
    @Column(name = "l_name")
    private String lName;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "administrative_rank")
    private String administrativeRank;
    @Column(name = "region_level")
    private String regionLevel;
    @Column
    private String region;
    @Column(name = "phone_number")
    private int phoneNumber;
    @Column
    private String password;

    public User(Integer id, String username, String fName, String lName, String emailAddress, String administrativeRank, String regionLevel, String region, int phoneNumber, String password) {
        this.id = id;
        this.username = username;
        this.fName = fName;
        this.lName = lName;
        this.emailAddress = emailAddress;
        this.administrativeRank = administrativeRank;
        this.regionLevel = regionLevel;
        this.region = region;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAdministrativeRank() {
        return administrativeRank;
    }

    public void setAdministrativeRank(String administrativeRank) {
        this.administrativeRank = administrativeRank;
    }

    public String getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(String regionLevel) {
        this.regionLevel = regionLevel;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
