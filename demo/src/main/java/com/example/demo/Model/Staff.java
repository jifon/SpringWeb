package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "staff")
@AllArgsConstructor
@NoArgsConstructor
// Работник фирмы тур оператора
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "passport_nummer")
    private String passportNummer;
    private String address;
    //(FK)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;

//    @OneToOne(mappedBy = "staff")
//    private TourTasks tourTasks;
//
//    @OneToOne(mappedBy = "staff")
//    private Order orders;


}
