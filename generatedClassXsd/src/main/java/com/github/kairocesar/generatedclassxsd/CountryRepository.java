package com.github.kairocesar.generatedclassxsd;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CountryRepository {

    public static final Map<String, Country> countries = new LinkedHashMap<>();

    //Se encontrar alguma anotação dessa, o container executa esses métodos automaticamente.
    @PostConstruct
    public void iniData(){
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);

        countries.put(spain.getName(), spain);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(38186860);

        countries.put(poland.getName(), poland);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(63705000);

        countries.put(uk.getName(), uk);
    }

    public Country findCountry(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return countries.get(name);
    }

//    public String getData(){
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://localhost:8080/ws/countries.wsdl";
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
//        return responseEntity.getBody();
//    }
}
