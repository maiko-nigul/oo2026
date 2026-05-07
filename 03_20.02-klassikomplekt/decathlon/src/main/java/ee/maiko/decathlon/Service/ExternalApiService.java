package ee.maiko.decathlon.Service;

import ee.maiko.decathlon.dto.JudgeDTO;
import ee.maiko.decathlon.dto.LocationDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ExternalApiService {

    private final String JUDGES = "https://69fcd19030ad0a6fd1c02f00.mockapi.io/judges";
    private final String LOCATIONS = "https://69fcd19030ad0a6fd1c02f00.mockapi.io/locations";
    private final RestTemplate restTemplate = new RestTemplate();

    public List<JudgeDTO> getJudges() {
        RestTemplate restTemplate = new RestTemplate();
        JudgeDTO[] response = restTemplate.getForObject(JUDGES, JudgeDTO[].class);
        return response != null ? Arrays.asList(response) : Collections.emptyList();
    }
    public List<LocationDTO> getLocations() {
        LocationDTO[] response = restTemplate.getForObject(LOCATIONS , LocationDTO[].class);
        return Arrays.asList(response);
    }
}