package backend;

import org.apache.http.client.HttpClient;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class TwitterSearchMapping {

    String BearerToken = "";
    HttpClient client = new ServerHttpClient().httpClient;

    @GetMapping("/twitter/search")
    public JSONObject TwitterSearchMapping(@RequestParam(value = "query", defaultValue = "default") String query) throws IOException, URISyntaxException {
        TwitterSearch search = new TwitterSearch(query, BearerToken);
        return search.getSearchResponse(client);
    }
}
