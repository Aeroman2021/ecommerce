package com.project.ecommerce.model.entity;

import com.project.ecommerce.model.entity.embedables.AuditFields;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "carts")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "cart",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @Builder.Default
    private Set<CartItem> cartItems= new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private CartStatusEnum status =CartStatusEnum.ACTIVE;

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    @OneToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private Order order;

    public enum CartStatusEnum {
        ACTIVE,FINALIZED,CANCELED
    }


    @Embedded
    private AuditFields auditFields;
}
