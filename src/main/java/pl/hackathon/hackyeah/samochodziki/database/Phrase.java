package pl.hackathon.hackyeah.samochodziki.database;

import javax.persistence.*;
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
    private long phraseId;

    @Column(name = "phrase", nullable = false)
    private String phrase;

//    private Set<Car> cars;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "phrase", orphanRemoval = true)
    private List<News> news = new LinkedList<>();

    public Phrase() {
    }

    public Phrase(long phraseId, String phrase/*, Set<Car> cars*/, List<News> news) {
        this.phraseId = phraseId;
        this.phrase = phrase;
//        this.cars = cars;
        this.news = news;
    }

//    @ManyToMany(mappedBy = "phrases")
//    public Set<Car> getCars() {
//        return cars;
//    }

//    public void setCars(Set<Car> cars) {
//        this.cars = cars;
//    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public long getPhraseId() {
        return phraseId;
    }

    public void setPhraseId(long phraseId) {
        this.phraseId = phraseId;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
