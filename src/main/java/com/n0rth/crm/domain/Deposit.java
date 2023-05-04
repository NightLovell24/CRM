package com.n0rth.crm.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "deposit")
public class Deposit {
    private final int SCALE = 2;
    private final RoundingMode ROUNDING_MODE = RoundingMode.CEILING;


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sum", scale = SCALE)
    private BigDecimal sum;

    public BigDecimal getValue() {
        return sum.setScale(SCALE, ROUNDING_MODE);
    }

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;
}
