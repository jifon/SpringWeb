package com.example.demo.Model;


import com.example.demo.constant.HotelRoomCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="hotel_rooms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelRooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "check_in")
    private Date checkIn;
    @Column(name = "room_number")
    private int roomNumber;
    @Column(name = "check_out")
    private Date check_out;
    @Enumerated(EnumType.STRING)
    private HotelRoomCategory hotelRoomCategory;
    //Удалила эту таблицу за ненадобностью
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "category_id")
//    private RoomCategory roomCategory;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToMany
    @JoinTable(name = "hotelRooms_travelPackage",
    joinColumns = @JoinColumn(name = "hotel_room_id"),
    inverseJoinColumns = @JoinColumn(name = "travel_package_id"))
    private List<TravelPackage> travelPackageList;
}
