package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "post")
@Data
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    private int salary;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Staff> staffList;

    public Post() {
    }
}
