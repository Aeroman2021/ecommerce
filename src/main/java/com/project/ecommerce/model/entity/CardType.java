package com.project.ecommerce.model.entity;

import com.project.ecommerce.model.entity.embedables.Description;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "card_types")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private Description description;

    private String brand;
}
