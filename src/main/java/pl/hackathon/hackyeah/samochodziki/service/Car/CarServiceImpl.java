package pl.hackathon.hackyeah.samochodziki.service.Car;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hackathon.hackyeah.samochodziki.database.Car;
import pl.hackathon.hackyeah.samochodziki.database.repository.CarRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> findAll() {

        updatePoints();

        return carRepository.findAll();
    }

    @Override
    public List<Car.CarRelative> getAllRelative() {

        updatePoints();

        List<Car.CarRelative> output = new LinkedList<>();

        Iterable<Car> carsIterable = findAll();
        List<Car> cars = new LinkedList<>();
        carsIterable.forEach(cars::add);

        double maxPoints = cars.
                        stream().
                        mapToInt(Car::getPoints).
                        max().
                        orElse(1);

        for(Car car : cars) {
            String carName = car.getName();
            int carPoints = car.getPoints();
            double relativePoints = carPoints / maxPoints; //int diveInt
            double relativePointsRounded = round(relativePoints, 2);
            Car.CarRelative carRelative = new Car.CarRelative(carName, relativePointsRounded);
            output.add(carRelative);
        }


        return output;
    }

    private void updatePoints() {
        //TODO: send it somehow, so it wont be called twice
        Iterable<Car> carsIterable = carRepository.findAll();

        for(Car car : carsIterable) {
            long idCar = car.getIdCar();
            List<Integer> gatheredPopularity = carRepository.popularityOfRelatedArticles(idCar);
            int currentPoints = gatheredPopularity.stream().reduce(0, Integer::sum);
            int previousPoints = car.getPoints();
            //TODO: need to rethink query or db design
            int pointsDifference = currentPoints - previousPoints;
            logger.info(car.toString());
            logger.info(gatheredPopularity.toString());
            logger.info(Integer.toString(previousPoints));
            logger.info(Integer.toString(currentPoints));
            car.setPoints(pointsDifference + previousPoints);
            carRepository.save(car);
        }

    }

    //TODO: move it to another class
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
