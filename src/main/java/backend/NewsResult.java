package backend;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;



public class NewsResult {
    private final String apiKey;
    private final String query;

    public NewsResult(String query, String apiKey) {
        this.apiKey = apiKey;
        this.query = query;
    }

    public JSONObject getSearchResponse(HttpClient httpClient) throws IOException, URISyntaxException {
        JSONObject searchResult = new JSONObject();

        URIBuilder uriBuilder = new URIBuilder("https://newsapi.org/v2/top-headlines");
        ArrayList<NameValuePair> queryParameters;
        queryParameters = new ArrayList<>();
        queryParameters.add(new BasicNameValuePair("country", "us"));
        queryParameters.add(new BasicNameValuePair("q", query));
        queryParameters.add(new BasicNameValuePair("apiKey", apiKey));
        uriBuilder.addParameters(queryParameters);

        HttpGet httpGet = new HttpGet(uriBuilder.build());

        return getJsonObject(httpClient, searchResult, httpGet);
    }

    static JSONObject getJsonObject(HttpClient httpClient, JSONObject searchResult, HttpGet httpGet) throws IOException {
        String searchResponse;
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        searchResponse = EntityUtils.toString(entity);

        JSONParser parser = new JSONParser();
        try {
            searchResult = (JSONObject) parser.parse(searchResponse);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return searchResult;
    }

}