package pl.hackathon.hackyeah.samochodziki.database;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="car")
public class Car {

    @Id
    @SequenceGenerator(name = "carIdSequenceGenerator", sequenceName = "car_id_car_seq", allocationSize = 1)
    @GeneratedValue(generator = "carIdSequenceGenerator")
    @Column(name = "id_car", nullable = false)
    private long carId;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "points", nullable = false)
    private int points;

    //TODO: does it needs adnotations
//    private Set<Phrase> phrases;

    public Car() {
    }

    public Car(long carId, int points/*, Set<Phrase> phrases*/) {
        this.carId = carId;
        this.points = points;
//        this.phrases = phrases;
    }

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "phrase_car", joinColumns = @JoinColumn(name = "id_car", referencedColumnName = "id_car"),
//            inverseJoinColumns = @JoinColumn(name = "id_phrase", referencedColumnName = "id_phrase"))
//    public Set<Phrase> getPhrases() {
//        return phrases;
//    }
//
//    public void setPhrases(Set<Phrase> phrases) {
//        this.phrases = phrases;
//    }

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
