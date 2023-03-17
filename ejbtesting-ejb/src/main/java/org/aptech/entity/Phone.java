package org.aptech.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Phone")
public class Phone implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "`number`")
    private String number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return number.equals(phone.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
