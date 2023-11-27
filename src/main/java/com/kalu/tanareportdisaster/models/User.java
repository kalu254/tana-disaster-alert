package com.kalu.tanareportdisaster.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "user_table")
@Entity
public class User {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
        name = "sequence-generator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "user_sequence"),
            @Parameter(name = "initial_value", value = "001"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    @Column
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "f_name")
    private String fName;
    @Column(name = "l_name")
    private String lName;
    @Column(name = "email_address")
    private String email;
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
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles_table",
        joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();
    @Transient
    private Set<String> role;


    public User(String username, String fName, String lName, String email, String administrativeLevel, String regionLevel, String region, int phoneNumber, String password, Set<String> role) {
        this.username = username;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.administrativeRank = administrativeLevel;
        this.regionLevel = regionLevel;
        this.region = region;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdministrativeLevel() {
        return administrativeRank;
    }

    public void setAdministrativeLevel(String administrativeLevel) {
        this.administrativeRank = administrativeLevel;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
