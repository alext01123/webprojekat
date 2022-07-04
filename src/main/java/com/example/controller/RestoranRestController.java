package com.example.controller;

import com.example.dto.*;
import com.example.entity.*;
import com.example.repository.RestoranRepository;
import com.example.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@RestController
public class RestoranRestController {
    @Autowired
    RestoranRepository restoranRepository;

    @Autowired
    RestoranService restoranService;


    @GetMapping("/restorani")
    public List<RestoranDto> welcome(){
        List<RestoranDto> restorani = restoranService.restorani();
        return  restorani;
    }

    @GetMapping("/restoran/{ime}")
    public ResponseEntity<RestoranStranicaDto> restoran(@PathVariable (value = "ime") String ime){
        Restoran restoran = restoranRepository.findByNaziv(ime);
        if(restoran == null){
            return new ResponseEntity("Restoran nije pronadjen", HttpStatus.NOT_FOUND);
        }

        Set<KomentarDto> komentari = restoranService.komentari(restoran);
        Set<Artikal> artikli = restoranService.artikli(restoran);
        float ocena = restoranService.ocena(restoran);
        RestoranDto restoranDto = new RestoranDto(restoran);
        RestoranStranicaDto restoranStranicaDto = new RestoranStranicaDto(restoranDto, ocena, komentari, artikli);
        return ResponseEntity.ok(restoranStranicaDto);
    }

    @GetMapping("/search/{ime}")
    public ResponseEntity<RestoranDto> findbyime(@PathVariable(value = "ime") String ime){ //todo: lista sa contains
        Restoran restoran = restoranRepository.findByNaziv(ime);
        if(restoran == null){
            return new ResponseEntity("Nije pronadjen restoran.", HttpStatus.NOT_FOUND);
        }
        RestoranDto restoranDto = new RestoranDto(restoran);
        return ResponseEntity.ok(restoranDto);
    }


//    @GetMapping("/search/lokacija")
//    public ResponseEntity<RestoranDto> findbylokacija(@RequestBody String lokacija){
//        RestoranDto restoranDto = restoranService.restorani_lokacija(lokacija);
//        if(restoranDto == null){
//            return new ResponseEntity("Nije validna lokacija.", HttpStatus.NOT_FOUND);
//        }
//        return ResponseEntity.ok(restoranDto);
//    }

    @PostMapping("/add/artikal")
    public ResponseEntity<String> addArtikal (@RequestBody Artikal artikal, HttpSession session){
        Korisnik logovaniKorisnik = (Menadzer)session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.MENADZER) {
            return new ResponseEntity("Nemate dozvolu za to!", HttpStatus.FORBIDDEN);
        }
        String response = restoranService.addArtikal(artikal, logovaniKorisnik);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/artikal/{id}")
    public ResponseEntity<Artikal> getartikal(@PathVariable(value = "id")Long id, HttpSession session)
    {
        Korisnik logovaniKorisnik = (Menadzer)session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.MENADZER) {
            return new ResponseEntity("Nemate dozvolu za to!", HttpStatus.FORBIDDEN);
        }
        Artikal artikal = restoranService.findArtikal(id, logovaniKorisnik);
        if(artikal == null){
            return new ResponseEntity("Ne postoji artikal u restoranu.", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(artikal);
    }
    @PostMapping("/artikal/{id}")
    public ResponseEntity<String> change (@RequestBody Artikal artikal, HttpSession session){
        Korisnik logovaniKorisnik = (Menadzer)session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.MENADZER) {
            return new ResponseEntity("Nemate dozvolu za to!", HttpStatus.FORBIDDEN);
        }
        String response = restoranService.changeArtikal(artikal, logovaniKorisnik);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/artikal/{id}/remove")
    public ResponseEntity<String> remove (@PathVariable(value = "id")Long id, HttpSession session) {
        Korisnik logovaniKorisnik = (Menadzer) session.getAttribute("korisnik");
        if (logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.MENADZER) {
            return new ResponseEntity("Nemate dozvolu za to!", HttpStatus.FORBIDDEN);
        }
        String response = restoranService.removeArtikal(id, logovaniKorisnik);
        return ResponseEntity.ok(response);
    }

}
