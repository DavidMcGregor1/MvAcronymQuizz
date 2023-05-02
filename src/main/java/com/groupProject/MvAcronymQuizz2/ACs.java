package com.groupProject.MvAcronymQuizz2;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Table(name = "AcronymCategoryMapping")
@Entity
public class ACs {

    private int id;
    private int categoryId;
    private int acronymId;




    public ACs() {

    }

    public ACs(int categoryId) {
        this.categoryId = categoryId;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "CategoryId", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "AcronymId", nullable = false)
    public int getAcronymId() {
        return acronymId;
    }

    public void setAcronymId(int acronymId) {
        this.acronymId = acronymId;
    }







}