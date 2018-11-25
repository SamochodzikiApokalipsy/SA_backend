package pl.hackathon.hackyeah.samochodziki.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.hackathon.hackyeah.samochodziki.database.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
