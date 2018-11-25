package pl.hackathon.hackyeah.samochodziki.crawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Formatter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class NewsCrawler {

    private final static String API_KEY = "e76bebc0cf404245aafbf8b9ab3091e0";

    public int getNumberOfTodayMentionsOfPhrase(String text) throws Exception {

        //TODO: move it should be another class instance
        Map<String, Integer> todayDateParts = getCurrentDate();

        URL url = createURLObject(text, todayDateParts.get("month"), todayDateParts.get("day"), todayDateParts.get("year"));
        HttpURLConnection httpURLConnection = createHttpURLConnection(url);
        String numberOfMentions = retrieveResponseContent(httpURLConnection);

        return Integer.parseInt(numberOfMentions);
    }

    private URL createURLObject(String text, int month, int day, int year) throws MalformedURLException {
        StringBuilder sb = new StringBuilder();
        Formatter formater = new Formatter(sb);
        formater.format("https://newsapi.org/v2/everything?" + "q=" + text + "&from=%d-%d-%d&" + "sortBy=popularity&" +
                "apiKey=" + API_KEY,day, month,year);
        String url = sb.toString();
        //TODO: tmp solution
        String encodedUrl = url.replaceAll(" ", "%20");


        return new URL(encodedUrl);
    }

    private HttpURLConnection createHttpURLConnection(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");

        return httpURLConnection;
    }

    private String retrieveResponseContent(HttpURLConnection httpURLConnection) throws IOException {

        //TODO: use json....
        BufferedReader in = new BufferedReader(
                new InputStreamReader(httpURLConnection.getInputStream()));
        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        String out =  response.toString().split(",")[1].split(":")[1];
        in.close();

        return out;
    }

    //TODO: move to another class
    private Map<String, Integer> getCurrentDate() {
        Map<String, Integer> datePart = new HashMap<>();

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        datePart.put("year", year);
        datePart.put("month", month);
        datePart.put("day", day);

        return datePart;
    }
}
