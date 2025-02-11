package com.example.test.demo.test.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDTO implements Serializable{

    private Long serialNumber = 1L;
    
    private String name;
    private String email;
    private Long mobile_number;
    private Date created_at;
    private String created_by;
    private Date updated_at;
}
