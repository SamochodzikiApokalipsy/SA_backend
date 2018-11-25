package pl.hackathon.hackyeah.samochodziki.database;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="phrase")
public class Phrase {

    @Id
    @SequenceGenerator(name = "phraseIdSequenceGenerator", sequenceName = "phrase_id_phrase_seq", allocationSize = 1)
    @GeneratedValue(generator = "phraseIdSequenceGenerator")
    @Column(name = "id_phrase", nullable = false)
    private long idPhrase;

    @Column(name = "phrase", nullable = false)
    private String phrase;

    @ManyToMany(
            mappedBy = "phrases")
    @JsonIgnore
    private Set<Car> cars = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "phrase", orphanRemoval = true)
    @JsonIgnore
    private List<News> news = new LinkedList<>();

    public Phrase() {
    }

    public Phrase(long phraseId, String phrase, List<News> news) {
        this.idPhrase = phraseId;
        this.phrase = phrase;
        this.news = news;
    }

    public Phrase(long phraseId, String phrase, Set<Car> cars, List<News> news) {
        this.idPhrase = phraseId;
        this.phrase = phrase;
        this.cars = cars;
        this.news = news;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    //    @ManyToMany(mappedBy = "phrases")
//    public Set<Car> getCars() {
//        return cars;
//    }
//
//    public void setCars(Set<Car> cars) {
//        this.cars = cars;
//    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public long getIdPhrase() {
        return idPhrase;
    }

    public void setIdPhrase(long idPhrase) {
        this.idPhrase = idPhrase;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
