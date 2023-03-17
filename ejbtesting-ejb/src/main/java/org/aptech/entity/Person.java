package org.aptech.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Phone> phones = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
