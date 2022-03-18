package com.example.demo.Model;

import com.example.demo.constant.AirTicketsClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "air_ticket")
@AllArgsConstructor
@NoArgsConstructor
public class AirTicket {
    @Id
    @GeneratedValue
    private int id;
    private String place;
    @Enumerated(EnumType.STRING)
    private AirTicketsClass airTicketsClass;
    //Удалила эту таблицу за ненадобностью
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "class_of_service")
//    private ClassOfAirTickets classOfService;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_flights_id")
    private TourFlights tourFlights;

    @ManyToMany
    @JoinTable(name = "travelPackage_airTicket",
            joinColumns = @JoinColumn(name = "air_ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "travel_package_id"))
    private List<TravelPackage> travelPackageList;
}
