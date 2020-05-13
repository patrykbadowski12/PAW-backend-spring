package com.paw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "array")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArrayEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name="array_id")
    private List<ListEntity> lists;

    public ArrayEntity(String name){
        this.name = name;
    }
}
