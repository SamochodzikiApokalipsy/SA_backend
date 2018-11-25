package pl.hackathon.hackyeah.samochodziki.crawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.Formatter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NewsCrawler {

    public static void main(String[] args) throws Exception {
        NewsCrawler newsCrawler = new NewsCrawler();
        int result = newsCrawler.getNumberOfMentionsOfPhrase("mama", 11, 11, 2018);
        System.out.println(result);
    }

    private final static String API_KEY = "414ea38308fc420eafee43bf6c9fd451";

    public int getNumberOfMentionsOfPhrase(String text, int month, int day, int year) throws Exception {

        URL url = createURLObject(text, month, day, year);
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
}
