package pl.hackathon.hackyeah.samochodziki.service.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hackathon.hackyeah.samochodziki.crawler.NewsCrawler;
import pl.hackathon.hackyeah.samochodziki.database.News;
import pl.hackathon.hackyeah.samochodziki.database.Phrase;
import pl.hackathon.hackyeah.samochodziki.database.repository.NewsRepository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    PhraseService phraseService;

    @Override
    public void updatePopularity() throws Exception {
        NewsCrawler newsCrawler = new NewsCrawler();
        Iterable<Phrase> phrases = phraseService.findAll();

        for(Phrase phrase: phrases) {
            String phraseText = phrase.getPhrase();
            int numberOfMentions = newsCrawler.getNumberOfTodayMentionsOfPhrase(phraseText);
            Timestamp timestamp = getCurrentTimestamp();
            News news = new News(numberOfMentions, timestamp, phrase);
            newsRepository.save(news);
        }
    }

    private Timestamp getCurrentTimestamp() {
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedTime = dateFormat.format(currentTime);
        Timestamp timestamp = Timestamp.valueOf(formattedTime);

        return timestamp;
    }

}
