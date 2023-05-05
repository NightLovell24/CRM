package com.n0rth.crm.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "managers")
public class Manager {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_credentials_id")
    private UserCredentials userCredentials;

    @OneToMany(mappedBy = "manager")
    private List<Client> clients;

    @OneToMany(mappedBy = "manager")
    private List<Deposit> deposits;


}
