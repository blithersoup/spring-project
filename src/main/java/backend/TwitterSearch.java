package backend;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static backend.NewsResult.getJsonObject;
import static java.lang.Character.isUpperCase;


public class TwitterSearch {
    private String searchString = "";
    private final String bearerToken;
    private String[] searchTerms;

    public TwitterSearch(String searchString, String bearerToken) {
        this.searchTerms = searchString.split("\\s+");
        this.bearerToken = bearerToken;
        StringBuilder searchStringBuilder = new StringBuilder();
        for (String searchTerm : searchTerms) {
            if (isUpperCase(searchTerm.charAt(0)) && !searchTerm.equals("The")) searchStringBuilder.append(searchTerm).append(" OR ");
        }
        searchStringBuilder.append("mountain");
        searchString = searchStringBuilder.toString();
        if (searchString.length() > 510) {
            searchString = searchString.substring(0,510);
        }
        this.searchString = searchString;
    }

    public JSONObject getSearchResponse(HttpClient httpClient) throws IOException, URISyntaxException {
        JSONObject searchResult = new JSONObject();

        URIBuilder uriBuilder = new URIBuilder("https://api.twitter.com/2/tweets/search/recent");
        ArrayList<NameValuePair> queryParameters;
        queryParameters = new ArrayList<>();
        queryParameters.add(new BasicNameValuePair("query", searchString));
        queryParameters.add(new BasicNameValuePair("max_results", "25"));
        queryParameters.add(new BasicNameValuePair("sort_order", "relevancy"));

        uriBuilder.addParameters(queryParameters);

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Authorization", String.format("Bearer %s", bearerToken)); //Add env variable
        httpGet.setHeader("Content-Type", "application/json");

        return getJsonObject(httpClient, searchResult, httpGet);
    }

}