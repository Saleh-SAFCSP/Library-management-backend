package com.example.library_managment.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "book_id",insertable = false,updatable = false)
    private Long book_id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnore
    private Books book;

    @Column(name = "user_id",insertable = false,updatable = false)
    private Long user_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users user;

    @NotBlank(message = "returnAt is required")
    @JsonFormat(pattern = "dd-mm-yyyy")
    private String returnAt;


}
