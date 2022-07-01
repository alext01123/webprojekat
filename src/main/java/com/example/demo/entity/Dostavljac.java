package com.example.demo.entity;


import java.io.Serializable;
import javax.persistence.*;
import java.rmi.UnexpectedException;
import java.util.List;


@Entity

public class Komentar implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKomentar;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "KupacKomentar", referencedColumnName = "idKorisnika")
    private Kupac kupac;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RestoranKomentar", referencedColumnName = "idRestorana")
    private Restoran restoran;

    @Column
    private String tekst;

    @Column
    private int ocena;

    public Komentar(){}

    public Komentar(Kupac kupac, Restoran restoran, String tekst, int ocena) {
        this.kupac = kupac;
        this.restoran = restoran;
        this.tekst = tekst;
        this.ocena = ocena;
    }

    public Long getIdKomentar() {
        return idKomentar;
    }

    public void setIdKomentar(Long idKomentar) {
        this.idKomentar = idKomentar;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
}
