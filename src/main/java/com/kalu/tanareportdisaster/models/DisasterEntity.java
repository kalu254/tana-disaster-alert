package com.kalu.tanareportdisaster.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "disaster_table")
@Entity
public class DisasterEntity {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
        name = "sequence-generator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @Parameter(name = "sequence_name", value = "disaster_sequence"),
            @Parameter(name = "initial_value", value = "1"),
            @Parameter(name = "increment_size", value = "1")
        }
    )
    @Column
    private int id;
    @Column
    private LocalDate date_reported;
    @Column
    private String disaster_type;
    @Column
    private String disaster_description;
    @Column
    private String village;
    @Column
    private String disaster_img_url_one;
    @Column
    private String disaster_img_url_two;
    @Column
    private String disaster_img_url_three;
    @Column
    private String disaster_img_url_four;

    @OneToOne()
    @JoinColumn(name = "id")
    private User user;


    public DisasterEntity() {
    }

    public int getDisaster_id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate_reported() {
        return date_reported;
    }

    public void setDate_reported(LocalDate date_reported) {
        this.date_reported = date_reported;
    }

    public String getDisaster_type() {
        return disaster_type;
    }

    public void setDisaster_type(String disaster_type) {
        this.disaster_type = disaster_type;
    }

    public String getDisaster_description() {
        return disaster_description;
    }

    public void setDisaster_description(String disaster_description) {
        this.disaster_description = disaster_description;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getDisaster_img_url_one() {
        return disaster_img_url_one;
    }

    public void setDisaster_img_url_one(String disaster_img_url_one) {
        this.disaster_img_url_one = disaster_img_url_one;
    }

    public String getDisaster_img_url_two() {
        return disaster_img_url_two;
    }

    public void setDisaster_img_url_two(String disaster_img_url_two) {
        this.disaster_img_url_two = disaster_img_url_two;
    }

    public String getDisaster_img_url_three() {
        return disaster_img_url_three;
    }

    public void setDisaster_img_url_three(String disaster_img_url_three) {
        this.disaster_img_url_three = disaster_img_url_three;
    }

    public String getDisaster_img_url_four() {
        return disaster_img_url_four;
    }

    public void setDisaster_img_url_four(String disaster_img_url_four) {
        this.disaster_img_url_four = disaster_img_url_four;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "DisasterEntity{" +
            "id=" + id +
            ", date_reported=" + date_reported +
            ", disaster_type='" + disaster_type + '\'' +
            ", disaster_description='" + disaster_description + '\'' +
            ", village='" + village + '\'' +
            ", disaster_img_url_one='" + disaster_img_url_one + '\'' +
            ", disaster_img_url_two='" + disaster_img_url_two + '\'' +
            ", disaster_img_url_three='" + disaster_img_url_three + '\'' +
            ", disaster_img_url_four='" + disaster_img_url_four + '\'' +
            ", user=" + user +
            '}';
    }
}
