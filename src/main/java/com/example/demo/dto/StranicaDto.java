package com.example.demo.dto;

import com.example.demo.entity.Artikal;
import com.example.demo.entity.Komentar;
import com.example.demo.entity.Lokacija;
import com.example.demo.entity.Restoran;


import java.util.List;
import java.util.Set;


public class StranicaDto {
    private String naziv;
    private String tip;
    private Set<Lokacija> lokacije;
    private float ocena;
    private StatusRestorana status;
    private Set<KomentarDto> komentari;
    private Set<Artikal> artikli;

    public StranicaDto() {
    }

    public StranicaDto(RestoranDto restoran, float ocena, Set<KomentarDto> komentari, Set<Artikal> artikli, StatusRestorana status) {
        this.naziv = restoran.getNaziv();
        this.tip = restoran.getTip_restorana();
        this.lokacije = restoran.getLokacije();
        this.ocena = ocena;
        this.komentari = komentari;
        this.artikli = artikli;
        this.status = status;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Set<Lokacija> getLokacije() {
        return lokacije;
    }

    public void setLokacije(Set<Lokacija> lokacije) {
        this.lokacije = lokacije;
    }

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }

    public StatusRestorana getStatus() {
        return status;
    }

    public void setStatus(StatusRestorana status) {
        this.status = status;
    }

    public Set<KomentarDto> getKomentari() {
        return komentari;
    }

    public void setKomentari(Set<KomentarDto> komentari) {
        this.komentari = komentari;
    }

    public Set<Artikal> getArtikli() {
        return artikli;
    }

    public void setArtikli(Set<Artikal> artikli) {
        this.artikli = artikli;
    }
}
