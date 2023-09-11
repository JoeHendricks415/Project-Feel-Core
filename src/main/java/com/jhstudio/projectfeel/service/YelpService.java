package com.jhstudio.projectfeel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@RestController
@RequestMapping(value = "/api/yelp", produces = "application/json")
public class YelpService {

    @Autowired
    @Qualifier("appEnvironmentConfig")
    private Properties appPropertiesConfig;

    @GetMapping("/{distance}/{term}/{zipCode}")
    public ResponseEntity<String> getRestaurants(@PathVariable String distance, @PathVariable String term, @PathVariable String zipCode) {

        String apiKey = (String) appPropertiesConfig.get("YELP_API_KEY");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + apiKey);
        headers.add("accept", "application/json");
        String url = "https://api.yelp.com/v3/businesses/search?sort_by=distance&limit=" + distance + "&term=" + term + "&location=" + zipCode;
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response);
        return response;
    }

    @GetMapping("/{distance}/{term}/{latitude}/{longitude}")
    public ResponseEntity<String> getRestaurantsByGeolocation(@PathVariable String distance, @PathVariable String term, @PathVariable String latitude, @PathVariable String longitude) {

        String apiKey = (String) appPropertiesConfig.get("YELP_API_KEY");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + apiKey);
        headers.add("accept", "application/json");
        String url = "https://api.yelp.com/v3/businesses/search?sort_by=distance&limit=" + distance + "&term=" + term + "&latitude=" + latitude + "&longitude=" + longitude;
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getRestaurantDetails(@PathVariable String id) {

        String apiKey = (String) appPropertiesConfig.get("YELP_API_KEY");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + apiKey);
        headers.add("accept", "application/json");
        String url = "https://api.yelp.com/v3/businesses/" + id;
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response);
        return response;
    }

}
