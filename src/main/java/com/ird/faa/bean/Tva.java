package com.ird.faa.bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


@Entity
@Table(name = "tva")
public class Tva {

    @Id
    @SequenceGenerator(name = "tva_seq", sequenceName = "tva_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tva_seq")
    private Long id;

    @Column(length = 500)
    private String reference;
    private BigDecimal pourcentage;


    public Tva() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BigDecimal getPourcentage() {
        return this.pourcentage;
    }

    public void setPourcentage(BigDecimal pourcentage) {
        this.pourcentage = pourcentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tva tva = (Tva) o;
        return id != null && id.equals(tva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

