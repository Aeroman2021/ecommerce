package com.project.ecommerce.model.entity;


import com.project.ecommerce.model.entity.embedables.AuditFields;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "wallets")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Wallet {

    @Id
    @Column(name = "user_id")
    private int user_id;

    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false,unique = true)
    private User user;

}
