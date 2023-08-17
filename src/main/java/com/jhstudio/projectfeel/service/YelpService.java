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
    @Qualifier("appPropertiesConfig")
    private Properties appPropertiesConfig;

    @GetMapping("/{distance}/{term}/{location}")
    public ResponseEntity<String> getRestaurants(@PathVariable String distance, @PathVariable String term, @PathVariable String location) {

        String apiKey = (String) appPropertiesConfig.get("API_KEY");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + apiKey);
        headers.add("accept", "application/json");
        String url = "https://api.yelp.com/v3/businesses/search?sort_by=distance&limit=" + distance + "&term=" + term + "&location=" + location;
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response);
        return response;
    }

}
