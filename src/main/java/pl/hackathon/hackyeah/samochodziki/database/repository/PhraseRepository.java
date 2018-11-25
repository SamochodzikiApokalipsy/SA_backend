package pl.hackathon.hackyeah.samochodziki.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.hackathon.hackyeah.samochodziki.database.Phrase;

@Repository
public interface PhraseRepository extends JpaRepository<Phrase, Long> {
}
