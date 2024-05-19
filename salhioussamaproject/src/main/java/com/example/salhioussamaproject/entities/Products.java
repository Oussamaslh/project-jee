package com.example.salhioussamaproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tilte;
    private String description;
    private int price;
    @OneToMany(mappedBy = "products")
    private List<Order> Order;

    public Products(Integer id, String iphone, String bestDescription, String number, int i) {
    }
}