package pl.hackathon.hackyeah.samochodziki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.hackathon.hackyeah.samochodziki.database.Car;
import pl.hackathon.hackyeah.samochodziki.service.Car.CarService;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<Car> result = carService.findAll();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllRelative")
    public ResponseEntity<?> getAllRelative() {
        List<Car.CarRelative> result = carService.getAllRelative();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
