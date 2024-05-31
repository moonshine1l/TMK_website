package ru.DmitryOrlov.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
    private List<Products> products;

}
