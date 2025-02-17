package com.example.test.demo.test.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDTO implements Serializable {

    @SuppressWarnings("unused")
    private static final Long serialVersionUID = 1L;

    
    private String name;
    private String email;
    private Long mobileNumber;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
