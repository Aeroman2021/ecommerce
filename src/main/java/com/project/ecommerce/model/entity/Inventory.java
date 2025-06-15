package com.project.ecommerce.model.entity;

import com.project.ecommerce.model.entity.embedables.AuditFields;
import com.project.ecommerce.model.entity.enums.InventoryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventories")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code", length = 16, unique = true, nullable = false)
    private String code;

    @Enumerated(EnumType.STRING)
    private InventoryStatus status;

    @ManyToOne
    @JoinColumn(name = "card_id",nullable = false)
    private Card card;

    @Embedded
    private AuditFields auditFields;
}
