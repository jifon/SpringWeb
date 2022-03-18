package com.example.demo.Model;

import com.example.demo.constant.HotelClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
@Data@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String city;
    private String name;
    @Enumerated(EnumType.STRING)
    private HotelClass hotelClass;
    //Удалила эту таблицу за ненадобностью
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "hotel_class")
//    private HotelClass hotelClass;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id")
    private Tour tour;




}
