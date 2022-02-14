package backend;

import org.apache.http.client.HttpClient;
import org.json.simple.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;


@RestController
public class NewsSearchMapping {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    String apiKey = "";
    HttpClient client = new ServerHttpClient().httpClient;

    @GetMapping("/news/search")
    public JSONObject NewsSearchMapping(@RequestParam(value = "query") String query) throws IOException, URISyntaxException {
        NewsResult search = new NewsResult(query, apiKey);
        return search.getSearchResponse(client);
    }
}
