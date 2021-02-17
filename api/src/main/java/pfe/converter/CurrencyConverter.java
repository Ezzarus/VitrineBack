package pfe.converter;

import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;

public class CurrencyConverter {

    public float convert_EUR_to_USD (float price) {

        final String uri = "https://api.exchangeratesapi.io/latest?symbols=USD";

        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject(uri, String.class);
        Gson gson = new Gson();
        RatesPOJO pojo = gson.fromJson(json, RatesPOJO.class);

        return (float) Math.round((pojo.rates.USD * price) * 100) / 100;
    }
}
