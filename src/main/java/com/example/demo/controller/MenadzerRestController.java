package com.example.demo.controller;

import com.example.demo.dto.PorudzbinaDto;
import com.example.demo.entity.*;
import com.example.demo.service.MenadzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Set;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class MenadzerRestController {
    @Autowired
    MenadzerService menadzerService;

    @GetMapping("/menadzer/restoran")
    public ResponseEntity<Restoran> mojrestoran(HttpSession session){
        Korisnik logovaniKorisnik = (Menadzer)session.getAttribute("korisnik");
        if(logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.MENADZER) {
            return new ResponseEntity("Nemate dozvolu za to.", HttpStatus.FORBIDDEN);
        }
        Restoran restoran = menadzerService.findrestoran(logovaniKorisnik);
        return ok(restoran);
    }

    @GetMapping("/menadzer/restoran/porudzbine")
    public ResponseEntity<Set<PorudzbinaDto>> mojeporudzbiine(HttpSession session) {
        Korisnik logovaniKorisnik = (Menadzer) session.getAttribute("korisnik");
        if (logovaniKorisnik == null || logovaniKorisnik.getUloga() != Uloga.MENADZER) {
            return new ResponseEntity("Nemate dozvolu za to.", HttpStatus.FORBIDDEN);
        }
        Set<PorudzbinaDto> porudzbine = menadzerService.findporudzbine(logovaniKorisnik);
        return new ResponseEntity<Set<PorudzbinaDto>>(porudzbine, HttpStatus.OK);
    }
}
