package com.project.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "regions")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    @Id
    @Column(name = "card_id")
    private int id;

    @Column(name = "title")
    private String title;

    @OneToOne
    @JoinColumn(name = "card_id",referencedColumnName = "id")
    private Card card;
}
