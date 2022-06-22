package com.library.dto;

import lombok.*;

import java.util.Date;

@Setter
public class BookDTO {
    private String fullName;
    private Date publishYear;

    public BookDTO() {
    }

    public Date getPublishYear() {
        return publishYear;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPublishYear(Date publishYear) {
        this.publishYear = publishYear;
    }
}
