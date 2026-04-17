package ee.maiko.decathlon.controller;

import ee.maiko.decathlon.Service.ScoringService;
import ee.maiko.decathlon.entity.Athlete;
import ee.maiko.decathlon.entity.Result;
import ee.maiko.decathlon.repository.AthleteRepository;
import ee.maiko.decathlon.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
// Me ei kasuta siin enam klassitasemel RequestMappingut
@RequiredArgsConstructor
public class AthleteController {

    private final AthleteRepository athleteRepository;
    private final ResultRepository resultRepository;
    private final ScoringService scoringService;


    @GetMapping("athletes")
    public List<Athlete> getAthlete() {
        return athleteRepository.findAll();
    }

    @PostMapping("athletes")
    public Athlete createAthlete(@RequestBody Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    @PostMapping("athletes/{id}/results")
    public Result addResult(@PathVariable Long id, @RequestBody Result result) {
        Athlete athlete = athleteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sportlast ei leitud"));

        int points = scoringService.calculatePoints(result.getDiscipline(), result.getValue());
        result.setPoints(points);

        result.setAthlete(athlete);

        return resultRepository.save(result);
    }
    
    @GetMapping("athletes/{id}/total")
    public Integer getTotalPoints(@PathVariable Long id) {
        Athlete athlete = athleteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sportlast ei leitud"));

        return athlete.getResults().stream()
                .mapToInt(Result::getPoints)
                .sum();
    }
}
