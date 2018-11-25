package pl.hackathon.hackyeah.samochodziki.service.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hackathon.hackyeah.samochodziki.database.Phrase;
import pl.hackathon.hackyeah.samochodziki.database.repository.PhraseRepository;

import java.util.List;

@Service
public class PhraseServiceImpl implements PhraseService {

    @Autowired
    PhraseRepository phraseRepository;

    @Override
    public List<Phrase> findAll() {
        return phraseRepository.findAll();
    }
}
