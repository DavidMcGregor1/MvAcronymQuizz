package com.groupProject.MvAcronymQuizz2;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Table(name = "Acronyms")
@Entity
public class Acronyms {

    private int id;
    private String acronymName;

    private String acronymMeaning;


    public Acronyms() {

    }

    public Acronyms(String acronymName, String acronymMeaning) {
        this.acronymName = acronymName;
        this.acronymMeaning = acronymMeaning;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Acronym", nullable = false)
    public String getAcronymName() {
        return acronymName;
    }

    public void setAcronymName(String acronymName) {
        this.acronymName = acronymName;
    }

    @Column(name = "Meaning", nullable = false)
    public String getAcronymMeaning() {
        return acronymMeaning;
    }

    public void setAcronymMeaning(String acronymMeaning) {
        this.acronymMeaning = acronymMeaning;
    }






}