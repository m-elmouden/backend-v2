package com.ird.faa.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "taux_ir")
@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorType(XmlAccessType.NONE)
public class TauxIr {

    @Id
    @SequenceGenerator(name = "taux_ir_seq", sequenceName = "taux_ir_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taux_ir_seq")
    private Long id;
    @XmlElement
    private String intervalle;
    @XmlElement
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateMin;
    @XmlElement
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateMax;
    @XmlElement
    private BigDecimal salaireImpoMin;
    @XmlElement
    private BigDecimal salaireImpoMax;
    @XmlElement
    private BigDecimal forfaitDeduit;
    @XmlElement
    private BigDecimal pourcentage;


    public TauxIr() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntervalle() {
        return intervalle;
    }

    public void setIntervalle(String intervalle) {
        this.intervalle = intervalle;
    }

    public Date getDateMin() {
        return this.dateMin;
    }

    public void setDateMin(Date dateMin) {
        this.dateMin = dateMin;
    }

    public Date getDateMax() {
        return this.dateMax;
    }

    public void setDateMax(Date dateMax) {
        this.dateMax = dateMax;
    }

    public BigDecimal getSalaireImpoMin() {
        return this.salaireImpoMin;
    }

    public void setSalaireImpoMin(BigDecimal salaireImpoMin) {
        this.salaireImpoMin = salaireImpoMin;
    }

    public BigDecimal getSalaireImpoMax() {
        return this.salaireImpoMax;
    }

    public void setSalaireImpoMax(BigDecimal salaireImpoMax) {
        this.salaireImpoMax = salaireImpoMax;
    }

    public BigDecimal getForfaitDeduit() {
        return this.forfaitDeduit;
    }

    public void setForfaitDeduit(BigDecimal forfaitDeduit) {
        this.forfaitDeduit = forfaitDeduit;
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
        TauxIr tauxIr = (TauxIr) o;
        return id != null && id.equals(tauxIr.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

