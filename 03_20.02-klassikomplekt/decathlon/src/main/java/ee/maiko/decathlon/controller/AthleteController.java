package ee.maiko.decathlon.controller;

import ee.maiko.decathlon.Service.ScoringService;
import ee.maiko.decathlon.entity.Athlete;
import ee.maiko.decathlon.entity.Result;
import ee.maiko.decathlon.repository.AthleteRepository;
import ee.maiko.decathlon.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
// Me ei kasuta siin enam klassitasemel RequestMappingut
@RequiredArgsConstructor
public class AthleteController {

    private final AthleteRepository athleteRepository;
    private final ResultRepository resultRepository;
    private final ScoringService scoringService;

    // 1. Lisa uus sportlane
    @PostMapping("athletes")
    public Athlete createAthlete(@RequestBody Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    // 2. Lisa tulemus sportlasele
    @PostMapping("athletes/{id}/results")
    public Result addResult(@PathVariable Long id, @RequestBody Result result) {
        // 1. Leia sportlane
        Athlete athlete = athleteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sportlast ei leitud"));

        // 2. ARVUTA PUNKTID (veendu, et siit tuleb midagi muud kui 0)
        int points = scoringService.calculatePoints(result.getDiscipline(), result.getValue());
        result.setPoints(points);

        // 3. SEO TULEMUS SPORTLASEGA (See samm on ülioluline!)
        result.setAthlete(athlete);

        // 4. Salvesta tulemus
        return resultRepository.save(result);
    }

    // 3. Hangi kogusumma
    @GetMapping("athletes/{id}/total")
    public Integer getTotalPoints(@PathVariable Long id) {
        Athlete athlete = athleteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sportlast ei leitud"));

        // Tagastab summat, mis on baasis
        return athlete.getResults().stream()
                .mapToInt(Result::getPoints)
                .sum();
    }
}
