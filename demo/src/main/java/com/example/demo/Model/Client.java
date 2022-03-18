package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "full_name")
    private String fullName;
    private String address;
//    // Счетный номер клиента
//    @Column(name = "clientNumber")
//    private int clientNumber;
    @Column(name = "client_phoneNumber")
    private String clientPhoneNumber;

    @OneToMany(mappedBy = "client")
    private List<Contract> contractList;
}
