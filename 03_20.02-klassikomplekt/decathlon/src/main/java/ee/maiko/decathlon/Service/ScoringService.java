package ee.maiko.decathlon.Service;

import org.springframework.stereotype.Service;

@Service
public class ScoringService {

    public int calculatePoints(String discipline, double performance) {
        // Lihtsustatud näide: A, B, C parameetrid (IAAF ametlikud)
        double a, b, c;
        boolean trackEvent = false;

        switch (discipline.toLowerCase()) {
            case "100m": a = 25.4347; b = 18.0; c = 1.81; trackEvent = true; break;
            case "longjump": a = 0.14354; b = 220; c = 1.4; break; // Kaugus on cm-tes
            // Lisa siia teised alad...
            default: throw new IllegalArgumentException("Tundmatu spordiala: " + discipline);
        }

        if (trackEvent) {
            return (int) (a * Math.pow(b - performance, c));
        } else {
            return (int) (a * Math.pow(performance - b, c));
        }
    }
}