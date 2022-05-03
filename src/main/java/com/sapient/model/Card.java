package com.sapient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Card {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique=true)
    private String cardnumber;
    private String name;
    private Integer cardlimit;

    public Card() {
    }

    public Card(String number, String name, Integer limit) {
        this.cardnumber = number;
        this.name = name;
        this.cardlimit = limit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String number) {
        this.cardnumber = number;
    }

    public Integer getCardlimit() {
        return cardlimit;
    }

    public void setCardlimit(Integer limit) {
        this.cardlimit = limit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
