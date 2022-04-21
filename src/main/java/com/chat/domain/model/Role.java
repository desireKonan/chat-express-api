package com.chat.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "name",
            columnDefinition = "character varying",
            length = 200
    )
    private String name;

    public Role() {
        this(Long.valueOf(0), "");
    }

    public Role(long id, String name) {
        this.id = Long.valueOf(id);
        this.name = name;
    }

    public Role(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = Long.valueOf(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
