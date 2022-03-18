package com.example.demo.Model;

import com.example.demo.constant.StatusOfTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

// Задания для составителя туров
@Entity
@Data
@Table(name = "tour_tasks")
@AllArgsConstructor
@NoArgsConstructor
public class TourTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String definition;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "executing_time")
    private Date executingTime;
    @Enumerated(EnumType.STRING)
    private StatusOfTask status;
//    private String status;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id")
    private Tour tour;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id")
    private Staff staff;





}
