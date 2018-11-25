package pl.hackathon.hackyeah.samochodziki.database;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="news")
public class News {

    @Id
    @SequenceGenerator(name = "newsIdSequenceGenerator", sequenceName = "news_id_news_seq", allocationSize = 1)
    @GeneratedValue(generator = "newsIdSequenceGenerator")
    @Column(name = "id_news", nullable = false)
    private long newsId;

    @Column(name = "popularity", nullable = false)
    private int popularity;

    @Column(name = "collected_Timestamp", nullable = false)
    private java.sql.Timestamp collectedTimestamp;

    @ManyToOne
    @JoinColumn(name="id_phrase", nullable=false)
    @JsonIgnore
    private Phrase phrase;

    public News(long newsId, int popularity, Timestamp collectedTimestamp, Phrase phrase) {
        this.newsId = newsId;
        this.popularity = popularity;
        this.collectedTimestamp = collectedTimestamp;
        this.phrase = phrase;
    }

    public News() {
    }

    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public Timestamp getCollectedTimestamp() {
        return collectedTimestamp;
    }

    public void setCollectedTimestamp(Timestamp collectedTimestamp) {
        this.collectedTimestamp = collectedTimestamp;
    }

    public Phrase getPhrase() {
        return phrase;
    }

    public void setPhrase(Phrase phrase) {
        this.phrase = phrase;
    }
}
