package com.project.ecommerce.model.entity;

import com.project.ecommerce.model.entity.embedables.AuditFields;
import com.project.ecommerce.model.entity.enums.OrderTypes;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;


    @Enumerated(EnumType.STRING)
    private OrderTypes orderTypes;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Transaction> transactions;

    @OneToOne(mappedBy = "order")
    private Cart cart;


    @Embedded
    private AuditFields auditFields;

}
