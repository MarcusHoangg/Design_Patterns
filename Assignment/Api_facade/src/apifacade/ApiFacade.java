package apifacade;

import java.io.IOException;

public class ApiFacade {
    private HttpService httpService;
    private JsonParserService jsonParserService;

    public ApiFacade() {
        this.httpService = new HttpService();
        this.jsonParserService = new JsonParserService();
    }

    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IOException, IllegalArgumentException {

        String json = httpService.get(urlString);
        return jsonParserService.getAttributeValue(json, attributeName);
    }
}