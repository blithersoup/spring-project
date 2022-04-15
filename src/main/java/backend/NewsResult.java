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

    public JSONObject getSearchResponse(HttpClient httpClient) throws IOException, URISyntaxException, ParseException {
        JSONObject searchResult = new JSONObject();

        URIBuilder uriBuilder = new URIBuilder("https://newsapi.org/v2/everything");
        ArrayList<NameValuePair> queryParameters;
        queryParameters = new ArrayList<>();
        queryParameters.add(new BasicNameValuePair("q", query));
        queryParameters.add(new BasicNameValuePair("language", "en"));
        queryParameters.add(new BasicNameValuePair("sortBy", "relevancy"));
        queryParameters.add(new BasicNameValuePair("pageSize", "10"));
        queryParameters.add(new BasicNameValuePair("apiKey", apiKey));
        uriBuilder.addParameters(queryParameters);

        HttpGet httpGet = new HttpGet(uriBuilder.build());

        JSONObject returned = getJsonObject(httpClient, searchResult, httpGet);
        if (returned.containsValue("error")) {
            JSONParser p = new JSONParser();
            String jsonString = "{\"articles\":[{\"title\": \"Error\", \"url\": \"Out of requests\"}]}"; //+ returned.get("message") + "\"}]}";
            return (JSONObject) p.parse(jsonString);
        }
        else {
            return returned;
        }

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