package pl.hackathon.hackyeah.samochodziki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.hackathon.hackyeah.samochodziki.service.Car.NewsService;


@Controller
public class NewsController {

    @Autowired
    NewsService newsService;

    @Scheduled(fixedRate=30000)
    @GetMapping("/test")
    @ResponseStatus(value = HttpStatus.OK)
    public void updatePopularity() throws Exception {
        newsService.updatePopularity();
    }

}
