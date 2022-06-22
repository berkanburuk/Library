package com.library.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class BookDTO {
    private String fullName;
    private Date publishYear;
    
}
