package backend;

import org.apache.http.client.HttpClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;

@CrossOrigin(origins = "localhost:3000")
@RestController
public class NewsSearchMapping {

    private final HttpClient client;

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    String apiKey = System.getenv("NEWS_BEARER");

    public NewsSearchMapping(HttpClient client) {
        this.client = client;
    }


    @GetMapping("/news/search")
    public JSONObject NewsMapping(@RequestParam(value = "query") String query) throws IOException, URISyntaxException, ParseException {
        NewsResult search = new NewsResult(query, apiKey);
        return search.getSearchResponse(client);
    }
}
