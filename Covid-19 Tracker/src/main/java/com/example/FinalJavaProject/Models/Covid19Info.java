package com.example.FinalJavaProject.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;



@Entity
@Table(name = "Covid19Info")

public class Covid19Info {

    @Id
    @Column(name = "id")
    private String Id;

    @Column(name = "state")
    private String state;

    @Column(name = "totaltestresults")
    private String totalTestResults;

    @Column(name = "positive")
    private String postive;

    @Column(name = "negative")
    private String negative;

    @Column(name = "death")
    private String death;

    @Column(name = "date")
    private String date;

    public Covid19Info(String state, String totalTestResults, String positive, String negative, String death,
                       String date){
        Id = UUID.randomUUID().toString();
        this.state = state;
        this.totalTestResults = totalTestResults;
        this.postive = positive;
        this.negative = negative;
        this.death = death;
        this.date = date;
    }

    public Covid19Info(){

    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTotalTestResults() {
        return totalTestResults;
    }

    public void setTotalTestResults(String totalTestResults) {
        this.totalTestResults = totalTestResults;
    }

    public String getPostive() {
        return postive;
    }

    public void setPostive(String postive) {
        this.postive = postive;
    }

    public String getNegative() {
        return negative;
    }

    public void setNegative(String negative) {
        this.negative = negative;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) throws ParseException {
        this.date = date;
    }


}
