package com.LaParcelaStudio.SmashReview.controller;


import com.LaParcelaStudio.SmashReview.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = {"*"}, exposedHeaders = {"Content-Disposition"})
@RequestMapping(value = "/apiStartGG/tournament")
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @PostMapping
    public ResponseEntity getTournaments(){
        tournamentService.getTournaments().block();
        return ResponseEntity.ok().body(tournamentService.getTournaments().block());
    }

}
