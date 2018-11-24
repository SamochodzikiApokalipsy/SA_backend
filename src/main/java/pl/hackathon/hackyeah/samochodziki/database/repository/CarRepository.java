package pl.hackathon.hackyeah.samochodziki.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.hackathon.hackyeah.samochodziki.database.Car;


@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
}

