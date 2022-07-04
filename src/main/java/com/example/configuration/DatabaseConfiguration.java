package com.example.configuration;
import com.example.dto.StatusRestorana;
import com.example.entity.*;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sound.sampled.FloatControl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Configuration
public class DatabaseConfiguration {
    @Autowired
    private ArtikalRepository artikalRepository;

    @Autowired
    private DostavljacRepository dostavljacRepository;

    @Autowired
    private KomentarRepository komentarRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private KupacRepository kupacRepository;

    @Autowired
    private LokacijaRepository lokacijaRepository;

    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private PorudzbinaRepository porudzbinaRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private StavkaRepository stavkaRepository;

    @Autowired
    private TipkupcaRepository tipkupcaRepository;

    @Bean
    public boolean instantiate() {
        Date datum1 = new GregorianCalendar(2001, 5, 11).getTime();
        Date datum2 = new GregorianCalendar(2002, 2, 9).getTime();
        Date datum3 = new GregorianCalendar(2001, 10, 22).getTime();
        Date datum4 = new GregorianCalendar(2022, 1, 1).getTime();


        Artikal pica = new Artikal("Pica", 250, "Hrana", 10, "Margarita mala");
        Artikal hamburger = new Artikal("Hamburger", 300, "Hrana", 15, "Veliki hamburger sa slaninom");
        Artikal koka_kola = new Artikal ("Koka kola", 150, "Pice", 100, "Flasica koka kole 0.5ml");
        Artikal voda = new Artikal ("Voda", 80, "Pice", 150, "Aqua Viva voda");

        Korisnik petar = new Korisnik("petar123", "sifra123", "Petar", "Petrovic", Pol.MUSKI, datum1);
        Korisnik marko = new Korisnik("Markooo", "sifra123", "Marko", "Markovic", Pol.MUSKI, datum2);
        Korisnik marija = new Korisnik("MarijaJo", "sifra123", "Marija", "Jovanovic", Pol.ZENSKI, datum3);
        marija.setUloga(Uloga.ADMIN);
        korisnikRepository.save(marija);

        Kupac mila = new Kupac();
        mila.setIme("Mila");
        mila.setLozinka("sifra123");
        mila.setKorisnicko("MilaM1");
        mila.setPrezime("Milanovic");
        mila.setDatum_rodjenja(datum1);
        mila.setPol(Pol.ZENSKI);
        mila.setUloga(Uloga.KUPAC);
        kupacRepository.save(mila);

        Lokacija lokacija1= new Lokacija(30.22, 258.13, "Bulevar Oslobodjenja 1");
        Set<Artikal> artikli = new HashSet<>();

        artikli.add(pica);
        artikli.add(hamburger);
        artikli.add(koka_kola);
        artikli.add(voda);

        Restoran minuta = new Restoran();
        minuta.setTip_restorana("Brza hrana");
        minuta.setLokacija(Set.of(lokacija1));
        minuta.setNaziv("Minuta");
        minuta.getArtikli().add(pica);
        minuta.getArtikli().add(hamburger);
        minuta.getArtikli().add(koka_kola);
        minuta.getArtikli().add(voda);
        restoranRepository.save(minuta);

        Stavka porucenartikal = new Stavka();
        porucenartikal.setArtikal(pica);
        porucenartikal.setBroj(3);

        Porudzbina porudzbina1 = new Porudzbina();
        porudzbina1.setRestoran(minuta);
        porudzbina1.setDatum(datum4);
        porudzbina1.setCena(250);
        porudzbina1.setStatus(Status.OBRADA);
        porudzbina1.setStavke(Set.of(porucenartikal));
        porudzbina1.setKupac((Kupac) mila);
        porudzbinaRepository.save(porudzbina1);

        Komentar komentar1 = new Komentar(mila, minuta, "Jako sam zadovoljna uslugom, samo je problem sto se dugo ceka", 4);
        komentarRepository.save(komentar1);

        Menadzer menadzer1 = new Menadzer(petar);
        menadzer1.setRestoran(minuta);
        menadzerRepository.save(menadzer1);

        return true;
    }


}
