package com.sapient.dto;

import java.math.BigDecimal;

public class CardResponse {
    private String number;
    private String name;
    private Integer limit;
    private BigDecimal balance;

    public CardResponse() {
    }

    public CardResponse(String number, String name, Integer limit) {
        this.number = number;
        this.name = name;
        this.limit = limit;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
