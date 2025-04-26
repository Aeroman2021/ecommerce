package com.project.E_Commerce.model.entity;

import com.project.E_Commerce.model.entity.embedables.AuditFields;
import com.project.E_Commerce.model.entity.embedables.Description;
import com.project.E_Commerce.model.entity.enums.Region;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "cards")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private BigDecimal price;

    @Column(name = "ir_price")
    private  BigDecimal irPrice;

    @Embedded
    private Description description;

    @Enumerated(EnumType.STRING)
    private Region region;


    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<OrderItem> orderItems;

    @Embedded
    private AuditFields auditFields;


}
