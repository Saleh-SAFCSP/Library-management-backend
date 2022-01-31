package com.example.library_managment.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @Column(name = "author_id",insertable = false,updatable = false)
    private Long author_id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "genre_id",insertable = false,updatable = false)
    private Long genre_id;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

}
