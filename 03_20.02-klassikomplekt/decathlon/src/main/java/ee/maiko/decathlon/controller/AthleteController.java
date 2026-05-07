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


    @GetMapping("athletes")
    public Page<Athlete> getAthletes(
            @RequestParam(required = false) String country, // Filtreerimine riigi (String) järgi
            Pageable pageable) { // Sisaldab page, size ja sort parameetreid

        if (country != null && !country.isEmpty()) {
            return athleteRepository.findByCountry(country, pageable);
        }
        return athleteRepository.findAll(pageable);
    }
    @DeleteMapping("athletes/{id}")
    public void  deleteAthlete(@PathVariable Long id) {
        athleteRepository.deleteById(id);
    }

    @PostMapping("athletes")
    public Athlete createAthlete(@RequestBody Athlete athlete) {
        athlete.setId(null);
        return athleteRepository.save(athlete);
    }

    @PostMapping("athletes/{id}/results")
    public Result addResult(@PathVariable Long id, @RequestBody Result result) {
        Athlete athlete = athleteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sportlast ei leitud"));
        result.setAthlete(athlete);

        if (result.getPoints() != null) {
            athlete.setTotalPoints(athlete.getTotalPoints() + result.getPoints());
        }

        athleteRepository.save(athlete);

        return result;
    }
    

}
