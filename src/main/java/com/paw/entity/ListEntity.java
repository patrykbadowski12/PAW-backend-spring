package com.paw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "list")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name="list_id")
    private List<CardEntity> cards;

    public ListEntity(String name) {
        this.name = name;
    }
}
