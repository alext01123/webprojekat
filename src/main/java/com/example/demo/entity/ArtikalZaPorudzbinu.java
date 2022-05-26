package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ArtikalZaPorudzbinu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_stavke;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artikal")
    private Artikal artikal;

    @Column
    private int broj;

    public ArtikalZaPorudzbinu() {}

    public ArtikalZaPorudzbinu(Artikal artikal, int broj, Long id_stavke) {
        this.artikal = artikal;
        this.broj = broj;
        this.id_stavke = id_stavke;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }

    public Long getId_stavke() {
        return id_stavke;
    }

    public void setId_stavke(Long id_stavke) {
        this.id_stavke = id_stavke;
    }
}