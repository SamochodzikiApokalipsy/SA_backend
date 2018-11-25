package pl.hackathon.hackyeah.samochodziki.service.Car;

import org.springframework.stereotype.Service;
import pl.hackathon.hackyeah.samochodziki.database.Phrase;

import java.util.List;

@Service
public interface PhraseService {
    List<Phrase> findAll();
}
