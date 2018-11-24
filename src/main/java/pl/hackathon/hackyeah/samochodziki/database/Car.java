package pl.hackathon.hackyeah.samochodziki.database;

import javax.persistence.*;

@Entity
@Table(name="car")
public class Car {

    @Id
    @SequenceGenerator(name = "idSequenceGenerator", sequenceName = "car_id_car_seq", allocationSize = 1)
    @GeneratedValue(generator = "idSequenceGenerator")
    @Column(name = "id_car", nullable = false)
    private long carId;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "points", nullable = false)
    private int points;

    @Column(name = "phrase", nullable = false)
    private String phrase;

    public Car() {
    }

    public Car(long carId, int points, String phrase) {
        this.carId = carId;
        this.points = points;
        this.phrase = phrase;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class CarRelative {
        private String name;
        private double pointsPercentage;

        public CarRelative(String name, double pointsPercentage) {
            this.name = name;
            this.pointsPercentage = pointsPercentage;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPointsPercentage() {
            return pointsPercentage;
        }

        public void setPointsPercentage(double pointsPercentage) {
            this.pointsPercentage = pointsPercentage;
        }
    }
}
