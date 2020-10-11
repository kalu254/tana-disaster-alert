package com.example.disastermanagement.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "disaster_table")
@Entity
public class DisasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disaster_id")
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
    @ManyToOne
    @JoinColumn(name = "chief_service_id")
    private ChiefEntity chief;


    public DisasterEntity() {
    }

    public int getDisaster_id() {
        return id;
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

    public ChiefEntity getChief() {
        return chief;
    }

    public void setChief(ChiefEntity chief) {
        this.chief = chief;
    }

    @Override
    public String toString() {
        return "Disaster{" +
            "disaster_id=" + id +
            ", date_reported=" + date_reported +
            ", disaster_type='" + disaster_type + '\'' +
            ", disaster_description='" + disaster_description + '\'' +
            ", village='" + village + '\'' +
            ", disaster_img_url_one='" + disaster_img_url_one + '\'' +
            ", disaster_img_url_two='" + disaster_img_url_two + '\'' +
            ", disaster_img_url_three='" + disaster_img_url_three + '\'' +
            ", disaster_img_url_four='" + disaster_img_url_four + '\'' +
            ", chief=" + chief +
            '}';
    }
}
