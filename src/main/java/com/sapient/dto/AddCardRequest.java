package com.sapient.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AddCardRequest {

    @NotEmpty(message = "Name is mandatory")
    private String name;
    @NotEmpty(message = "Card Number is mandatory")
    @Pattern(regexp="^[0-9]{1,19}$",message="length must be between 1 to 19 and must contain only digits")
    private String number;
    @NotNull
    private Integer limit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
