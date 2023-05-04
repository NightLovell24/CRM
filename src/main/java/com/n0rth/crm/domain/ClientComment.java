package com.n0rth.crm.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client_comment")
public class ClientComment {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "info")
    private String info;

    @CreationTimestamp
    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}

