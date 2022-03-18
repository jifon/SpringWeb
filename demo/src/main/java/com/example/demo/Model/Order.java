package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    // Счетный номер тура
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id")
    private Staff staff;
}
