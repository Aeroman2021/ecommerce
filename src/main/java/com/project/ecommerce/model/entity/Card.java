package com.project.ecommerce.model.entity;

import com.project.ecommerce.model.entity.embedables.AuditFields;
import com.project.ecommerce.model.entity.embedables.Description;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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

    @ManyToOne
    @JoinColumn(name = "card_type_id")
    private CardType cardType;

    @OneToMany(mappedBy = "card")
    private List<Inventory> inventoryList = new ArrayList<>();

    @Embedded
    private Description description;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @Embedded
    private AuditFields auditFields;

}
