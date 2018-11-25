package pl.hackathon.hackyeah.samochodziki.database;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="car")
public class Car {

    @Id
    @SequenceGenerator(name = "carIdSequenceGenerator", sequenceName = "car_id_car_seq", allocationSize = 1)
    @GeneratedValue(generator = "carIdSequenceGenerator")
    @Column(name = "id_car", nullable = false)
    private long idCar;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "points", nullable = false)
    private int points;

    //TODO: does it needs adnotations
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "phrase_car",
            joinColumns = { @JoinColumn(name = "id_car") },
            inverseJoinColumns = { @JoinColumn(name = "id_phrase") })
    @JsonIgnore
    private Set<Phrase> phrases = new HashSet<>();

    public Car() {
    }

    //TODO: according to tut it's necessary as well as in phrases
    public Car(long carId, String name, int points) {
        this.idCar = carId;
        this.name = name;
        this.points = points;
    }

    public Car(long carId, int points, Set<Phrase> phrases) {
        this.idCar = carId;
        this.points = points;
        this.phrases = phrases;
    }

    public Set<Phrase> getPhrases() {
        return phrases;
    }

    public void setPhrases(Set<Phrase> phrases) {
        this.phrases = phrases;
    }

    //
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

    public long getIdCar() {
        return idCar;
    }

    public void setIdCar(long idCar) {
        this.idCar = idCar;
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
