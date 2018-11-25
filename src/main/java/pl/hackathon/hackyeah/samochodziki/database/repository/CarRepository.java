package pl.hackathon.hackyeah.samochodziki.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.hackathon.hackyeah.samochodziki.database.Car;

import java.util.List;


@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

    @Query(value = "select news.popularity from car JOIN phrase_car pc ON pc.id_car = car.id_car JOIN phrase ph ON pc.id_phrase = ph.id_phrase JOIN news ON ph.id_phrase = news.id_phrase where car.id_car = :idCar",
    nativeQuery = true)
    List<Integer> popularityOfRelatedArticles(@Param("idCar") long idCar);
}

