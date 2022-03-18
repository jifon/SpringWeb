package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tour_program")
@AllArgsConstructor
@NoArgsConstructor
// Перечеть основных мероприятий тура
public class TourProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  programmNumber;
    private String description;
}
