package com.example.disastermanagement.models;

import javax.persistence.*;

@Table(name = "affected_unit_table")
@Entity
public class AffectedUnitEntity {

    @Id
    @Column
    private int id_no;
    @Column
    private String f_name;
    @Column
    private String l_name;
    @Column
    private int occupants;
    @Column
    private int p_l_w_d;
    @Column
    private int children_under_five;
    @Column
    private String village;
    @OneToOne
    @JoinColumn(name = "disaster_id")
    private DisasterEntity disasterEntity;
    @OneToOne
    @JoinColumn(name = "chief_service_id")
    private ChiefEntity chief;

    public AffectedUnitEntity() {
    }


    public int getId_no() {
        return id_no;
    }

    public void setId_no(int id_no) {
        this.id_no = id_no;
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

    public DisasterEntity getDisasterEntity() {
        return disasterEntity;
    }

    public void setDisasterEntity(DisasterEntity disasterEntity) {
        this.disasterEntity = disasterEntity;
    }

    public int getOccupants() {
        return occupants;
    }

    public void setOccupants(int occupants) {
        this.occupants = occupants;
    }

    public int getP_l_w_d() {
        return p_l_w_d;
    }

    public void setP_l_w_d(int p_l_w_d) {
        this.p_l_w_d = p_l_w_d;
    }

    public int getChildren_under_five() {
        return children_under_five;
    }

    public void setChildren_under_five(int children_under_five) {
        this.children_under_five = children_under_five;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public DisasterEntity getDisaster() {
        return disasterEntity;
    }

    public void setDisaster(DisasterEntity disasterEntity) {
        this.disasterEntity = disasterEntity;
    }

    public ChiefEntity getChief() {
        return chief;
    }

    public void setChief(ChiefEntity chief) {
        this.chief = chief;
    }

    @Override
    public String toString() {
        return "AffectedUnit{" +
            "house_hold_head_id=" + id_no +
            ", fname='" + f_name + '\'' +
            ", lname='" + l_name + '\'' +
            ", occupants=" + occupants +
            ", p_l_w_d=" + p_l_w_d +
            ", children_under_five=" + children_under_five +
            ", village='" + village + '\'' +
            ", disaster=" + disasterEntity +
            ", chief=" + chief +
            '}';
    }
}
