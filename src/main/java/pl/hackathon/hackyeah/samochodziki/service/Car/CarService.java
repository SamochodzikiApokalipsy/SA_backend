package pl.hackathon.hackyeah.samochodziki.service.Car;

import pl.hackathon.hackyeah.samochodziki.database.Car;

import java.util.List;

public interface CarService {
     List<Car> findAll();
     List<Car.CarRelative> getAllRelative();

}
