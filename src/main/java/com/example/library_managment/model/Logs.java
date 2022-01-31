package com.example.library_managment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Logs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Message cannot be blank")
    private String message;

    private String createdAt;

    public Logs(String message){
        this.message=message;
    }

    @PrePersist
    public  void onCreate(){
        createdAt=new Date().toString();
    }





}
