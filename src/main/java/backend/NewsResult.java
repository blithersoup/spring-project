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
            String jsonString = "{\"articles\":[{\"author\":\"https:\\/\\/www.facebook.com\\/bbcnews\",\"urlToImage\":\"https:\\/\\/ichef.bbci.co.uk\\/news\\/1024\\/branded_news\\/4A97\\/production\\/_124259091_opecindex.png\",\"description\":\"Oil prices are at an eight-year high, so why won't oil exporting countries bring them down?\",\"source\":{\"name\":\"BBC News\",\"id\":\"bbc-news\"},\"title\":\"Oil prices have soared. Why won't Opec bring them down?\",\"url\":\"https:\\/\\/www.bbc.co.uk\\/news\\/business-61188579\"},{\"author\":\"Andrew Higgins and Benjamin Novak\",\"urlToImage\":\"https:\\/\\/static01.nyt.com\\/images\\/2022\\/05\\/19\\/world\\/xxhungary-russia01\\/merlin_206508993_087277a6-b12a-432a-917e-5b1054ad7ba0-facebookJumbo.jpg\",\"description\":\"Prime Minister Viktor Orban has promised voters to keep energy prices low. The dividends from taking Russian fuel also help fund the policies that have made Hungary a beacon for right-wing groups.\",\"source\":{\"name\":\"New York Times\",\"id\":null},\"title\":\"Hooked on Cheap Oil, Hungary Resists an Embargo on Russia\",\"url\":\"https:\\/\\/www.nytimes.com\\/2022\\/05\\/19\\/world\\/europe\\/hungary-russia-oil.html\"},{\"author\":\"Somini Sengupta\",\"urlToImage\":\"https:\\/\\/static01.nyt.com\\/images\\/2022\\/05\\/06\\/climate\\/06cli-newsletter\\/06cli-newsletter-facebookJumbo.jpg\",\"description\":\"Here are four climate takeaways from a dramatic turnaround \\u2014 a year after a surge of shareholder activism in the industry, as well as a remarkable court ruling against Shell.\",\"source\":{\"name\":\"New York Times\",\"id\":null},\"title\":\"Oil Profits Soar, but the Industry\\u2019s Path Forward Remains Uncertain\",\"url\":\"https:\\/\\/www.nytimes.com\\/2022\\/05\\/06\\/climate\\/shell-exxon-profits-climate.html\"},{\"author\":\"Nadeen Ebrahim\",\"urlToImage\":\"https:\\/\\/media.cnn.com\\/api\\/v1\\/images\\/stellar\\/prod\\/220506104656-02-mideast-newsletter-opec.jpg?c=16x9&q=w_800,c_fill\",\"description\":\"A decades-old, failed effort by United States politicians to break the chokehold of a select few countries on the oil market has found new life as the war in Ukraine raised prices to an almost 14-year high.\",\"source\":{\"name\":\"CNN\",\"id\":\"cnn\"},\"title\":\"Why US politicians are trying to break the world's oil cartel now\",\"url\":\"https:\\/\\/www.cnn.com\\/2022\\/05\\/06\\/business\\/nopec-us-oil-mime-intl\\/index.html\"},{\"author\":null,\"urlToImage\":\"https:\\/\\/www.reuters.com\\/pf\\/resources\\/images\\/reuters\\/reuters-default.png?d=94\",\"description\":\"Qatar is set to lower the price differential of its crude grades relative to the average price of the Dubai and Oman benchmarks in June, state producer Qatar Energy said on Tuesday.\",\"source\":{\"name\":\"Reuters\",\"id\":\"reuters\"},\"title\":\"Qatar cuts June crude oil prices - Reuters\",\"url\":\"https:\\/\\/www.reuters.com\\/business\\/energy\\/qatar-cuts-june-crude-oil-prices-2022-05-10\\/\"},{\"author\":null,\"urlToImage\":\"https:\\/\\/www.reuters.com\\/resizer\\/CxUtYj81x1jJ4TIVTei9x4unQZc=\\/1200x628\\/smart\\/filters:quality(80)\\/cloudfront-us-east-2.images.arcpublishing.com\\/reuters\\/OIVTBXZ7MFNWFJUJOS43CTMD3E.jpg\",\"description\":\"Indian oil minister Hardeep Singh Puri said oil prices staying at $110\\/barrel could pose bigger threats than inflation to the global economy.\",\"source\":{\"name\":\"Reuters\",\"id\":\"reuters\"},\"title\":\"Oil prices at $110\\/bbl pose 'bigger threats' than inflation -India Oil Min - Reuters\",\"url\":\"https:\\/\\/www.reuters.com\\/markets\\/commodities\\/oil-prices-110bbl-pose-bigger-threats-than-inflation-india-oil-min-2022-05-23\\/\"},{\"author\":null,\"urlToImage\":\"https:\\/\\/www.reuters.com\\/resizer\\/W88y3AGR-avimGXY4BsNiDn7zKA=\\/1200x628\\/smart\\/filters:quality(80)\\/cloudfront-us-east-2.images.arcpublishing.com\\/reuters\\/BB4TATOWPVOABO4LME2MCST27E.jpg\",\"description\":\"Oil prices edged lower in early Asian trade on Thursday as concerns about rising coronavirus cases in China, the world's biggest oil importer, weighed on futures markets.\",\"source\":{\"name\":\"Reuters\",\"id\":\"reuters\"},\"title\":\"Oil edges lower as mass COVID testing begins in China - Reuters\",\"url\":\"https:\\/\\/www.reuters.com\\/business\\/energy\\/oil-edges-lower-mass-covid-testing-begins-china-2022-04-28\\/\"},{\"publishedAt\":\"2022-05-17T09:21:00Z\",\"author\":null,\"urlToImage\":\"https:\\/\\/www.reuters.com\\/resizer\\/TztfBhd0Euyyi6C5upw96WA57C0=\\/1200x628\\/smart\\/filters:quality(80)\\/cloudfront-us-east-2.images.arcpublishing.com\\/reuters\\/K3VGJ32GLZL2HKPKCU6YBI2UNM.jpg\",\"description\":\"Indonesia, the world's biggest palm oil exporter, has since April 28 halted shipments of the edible oil in a bid to flood the domestic market with supplies to control the soaring prices of cooking oil.\",\"source\":{\"name\":\"Reuters\",\"id\":\"reuters\"},\"title\":\"Explainer: Why Indonesia's palm oil export ban has not cooled cooking oil prices - Reuters.com\",\"url\":\"https:\\/\\/www.reuters.com\\/markets\\/commodities\\/why-indonesias-palm-oil-export-ban-has-not-cooled-cooking-oil-prices-2022-05-17\\/\",\"content\":\"May 17 (Reuters) - Indonesia, the world's biggest palm oil exporter, has since April 28 halted shipments of the edible oil in a bid to flood the domestic market with supplies to control the soaring p\\u2026 [+4066 chars]\"},{\"publishedAt\":\"2022-04-29T12:17:00Z\",\"author\":null,\"urlToImage\":\"https:\\/\\/www.reuters.com\\/pf\\/resources\\/images\\/reuters\\/reuters-default.png?d=90\",\"description\":\"Imperial Oil Ltd <a href=\\\"https:\\/\\/www.reuters.com\\/companies\\/IMO.TO\\\" target=\\\"_blank\\\">(IMO.TO)<\\/a> on Friday reported first-quarter profit that nearly tripled, as the Canadian oil major benefited from soaring oil prices.\",\"source\":{\"name\":\"Reuters\",\"id\":\"reuters\"},\"title\":\"Imperial Oil quarterly profit nearly triples on surging crude prices - Reuters\",\"url\":\"https:\\/\\/www.reuters.com\\/business\\/energy\\/imperial-oil-quarterly-profit-nearly-triples-surging-crude-prices-2022-04-29\\/\",\"content\":\"April 29 (Reuters) - Imperial Oil Ltd (IMO.TO) on Friday reported first-quarter profit that nearly tripled, as the Canadian oil major benefited from soaring oil prices.\\r\\nDuring the quarter, global cr\\u2026 [+1417 chars]\"},{\"publishedAt\":\"2022-04-29T16:59:00Z\",\"author\":null,\"urlToImage\":\"https:\\/\\/www.reuters.com\\/resizer\\/cq4PeM5FXKUmbE8iNK3KNjdZUdU=\\/1200x628\\/smart\\/filters:quality(80)\\/cloudfront-us-east-2.images.arcpublishing.com\\/reuters\\/IY3ERHZCBBMAZCIQR3DFWV763Q.jpg\",\"description\":\"Consumers and politicians may be annoyed at high oil prices, but they aren\\u2019t persuading Exxon Mobil <a href=\\\"https:\\/\\/www.reuters.com\\/companies\\/XOM.N\\\" target=\\\"_blank\\\">(XOM.N)<\\/a> or Chevron <a href=\\\"https:\\/\\/www.reuters.com\\/companies\\/CVX.N\\\" target=\\\"_blank\\\">(CVX\\u2026\",\"source\":{\"name\":\"Reuters\",\"id\":\"reuters\"},\"title\":\"Big Oil snubs commodity shortages - Reuters\",\"url\":\"https:\\/\\/www.reuters.com\\/breakingviews\\/big-oil-snubs-commodity-shortages-2022-04-29\\/\",\"content\":\"NEW YORK, April 29 (Reuters Breakingviews) - Consumers and politicians may be annoyed at high oil prices, but they arent persuading Exxon Mobil (XOM.N) or Chevron (CVX.N) to increase production drama\\u2026 [+3321 chars]\"}],\"status\":\"ok\"}";
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