package ee.maiko.decathlon.controller;

import ee.maiko.decathlon.Service.ExternalApiService;
import ee.maiko.decathlon.dto.JudgeDTO;
import ee.maiko.decathlon.dto.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/external")
public class ExternalApiController {

    @Autowired
    private ExternalApiService externalApiService;

    @GetMapping("/judges")
    public List<JudgeDTO> getAllJudges() {
        return externalApiService.getJudges();
    }
    @GetMapping("/locations")
    public List<LocationDTO> fetchLocations() {
        return externalApiService.getLocations();
    }
}