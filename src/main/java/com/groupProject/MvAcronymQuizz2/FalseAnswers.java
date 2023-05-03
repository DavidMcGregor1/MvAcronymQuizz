package com.groupProject.MvAcronymQuizz2;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Table(name = "FalseAnswers")
@Entity
public class FalseAnswers {

    private int id;
    private int acronymId;
    private String falseAnswer;




    public FalseAnswers() {

    }

    public FalseAnswers(int acronymId, String falseAnswer) {
        this.acronymId = acronymId;
        this.falseAnswer = falseAnswer;
    }





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "AcronymId", nullable = false)
    public int getAcronymId() {
        return acronymId;
    }

    public void setAcronymId(int acronymId) {
        this.acronymId = acronymId;
    }

    @Column(name = "FalseAnswer", nullable = false)
    public String getFalseAnswer() {
        return falseAnswer;
    }

    public void setFalseAnswer(String falseAnswer) {
        this.falseAnswer = falseAnswer;
    }







}