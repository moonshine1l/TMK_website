package ru.DmitryOrlov.model;

import lombok.Data;

import javax.persistence.*;



@Data
@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column (name = "description")
    private String description;

    @Column (name = "price")
    private String price;



    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

}
