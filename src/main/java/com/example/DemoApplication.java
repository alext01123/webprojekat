package com.example;


import com.example.entity.Artikal;
import com.example.entity.Korisnik;
import com.example.entity.Restoran;


import com.example.repository.KorisnikRepository;
import com.example.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private KorisnikRepository korisnikRepository;

	@Autowired
	private RestoranRepository restoranRepository;

	@Override
	public void run(String... args) throws Exception{
		Korisnik korisnik = new Korisnik();
		korisnik.setKorisnicko("DunjaJo01");
		korisnik.setIme("Dunja");
		korisnik.setPrezime("Jovanovic");
		korisnik.setLozinka("dunjasifra");

		this.korisnikRepository.save(korisnik);
		List<Korisnik> lista = this.korisnikRepository.findAll();
		for(Korisnik k : lista){
			System.out.println(k);
		}

		List<Restoran> r = restoranRepository.findAll();
		Restoran r1 = r.get(0);
		Set<Artikal> a = r1.getArtikli();
		for(Artikal aa : a){
			System.out.println(aa.getNaziv());
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
