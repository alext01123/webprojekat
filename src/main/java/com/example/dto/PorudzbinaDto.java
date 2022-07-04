package com.example.dto;


import com.example.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;
import java.io.Serializable;
import javax.persistence.*;

public class PorudzbinaDto {

    private UUID uuid;

    private Set<Stavka> stavke = new HashSet<>();

    private RestoranDto restoran;

    private Date datum;

    private float cena;

    private KorisnikDto kupac;

    private Status status;


    public PorudzbinaDto() {
    }

    public PorudzbinaDto(Porudzbina p) {
        this.stavke = p.getStavke();
        this.restoran = new RestoranDto(p.getRestoran());
        this.datum = p.getDatum();
        this.cena = p.getCena();
        this.kupac = new KorisnikDto(p.getKupac());
        this.status = p.getStatus();
        this.uuid = p.getUuid();
    }

    public PorudzbinaDto(Set<Stavka> stavke, RestoranDto restoran, float cena) {
        this.stavke = stavke;
        this.restoran = restoran;
        this.cena = cena;
    }

    public Set<Stavka> getStavke() {
        return stavke;
    }

    public void setStavke(Set<Stavka> stavke) {
        this.stavke = stavke;
    }

    public RestoranDto getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = new RestoranDto(restoran);
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public KorisnikDto getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = new KorisnikDto(kupac);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
