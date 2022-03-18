package com.example.demo.Model;

import com.example.demo.constant.TypeOfTour;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tour")
@AllArgsConstructor
@NoArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tour_number")
    private int tourNumber;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    // Краткая характеристика тура
    @Column(name = "tour_name")
    private String tour_name;
    private String status;
    @Enumerated(EnumType.STRING)
    private TypeOfTour typeOfTour;
    //Удалила эту таблицу за ненадобностью
    //(FK)
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "tour_type")
//    private TypeOfTour tourType;
    //(FK)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;
    //(FK)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="program_number", columnDefinition = "INTEGER")
    private TourProgram programNumber;
    @OneToMany(mappedBy = "tour", fetch = FetchType.LAZY)
    private List<Events> eventsList;
    @OneToOne(mappedBy = "tour")
    private TourTasks tourTasks;
    @OneToOne(mappedBy = "tour")
    private Order orders;
    @OneToMany(mappedBy = "tour")
    private List<TourFlights> tourFlightsList;
    @OneToMany(mappedBy = "tour")
    private List<Hotel> hotelList;
    @OneToMany(mappedBy = "tour")
    private List<Contract> contractList;
}
