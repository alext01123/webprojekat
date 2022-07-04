package com.example.entity;
import com.example.dto.StatusRestorana;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
public class Restoran implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRestorana;

    @Column
    private String naziv;

    @Column
    private String tip;

    @Enumerated(EnumType.STRING)
    @Column
    private StatusRestorana status;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Artikal> artikli = new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Lokacija> lokacije = new HashSet<>();


    public Restoran(){}

    public Restoran(String naziv, String tip_restorana, Set<Artikal> artikli, Set<Lokacija> lokacije) {
        this.naziv = naziv;
        this.tip = tip_restorana;
        this.artikli = artikli;
        this.lokacije = lokacije;
    }

    public Restoran(String naziv, String tip_restorana, Set<Lokacija> lokacije) {
        this.naziv = naziv;
        this.tip = tip_restorana;
        this.lokacije = lokacije;
    }

    public Long getIdLokacija() {
        return this.idRestorana;
    }

    public void setIdLokacija(Long idRestorana) {
        this.idRestorana = idRestorana;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip_restorana() {
        return tip;
    }

    public void setTip_restorana(String tip_restorana) {
        this.tip = tip_restorana;
    }

    public Set<Artikal> getArtikli() {
        return artikli;
    }

    public void setArtikli(Set<Artikal> artikli) {
        this.artikli = artikli;
    }

    public Set<Lokacija> getLokacija() {
        return lokacije;
    }

    public void setLokacija(Set<Lokacija> lokacije) {
        this.lokacije = lokacije;
    }

    public StatusRestorana getStatus() {
        return status;
    }

    public void setStatus(StatusRestorana status) {
        this.status = status;
    }
}