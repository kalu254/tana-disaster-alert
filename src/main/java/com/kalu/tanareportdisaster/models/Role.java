package com.kalu.tanareportdisaster.models;


import javax.persistence.*;

@Entity
@Table(name = "roles_table")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ApplicationUserRole name;

    public Role() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ApplicationUserRole getName() {
        return name;
    }

    public void setName(ApplicationUserRole name) {
        this.name = name;
    }
}

