package br.com.letscode.harrypotterapi.service;

import br.com.letscode.harrypotterapi.entity.House;
import br.com.letscode.harrypotterapi.entity.Student;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumingApi {

    private static final String webService = "https://api-harrypotter.herokuapp.com/";

    public static Student sortingHat() {
        var restTemplate = new RestTemplate();
        var response = restTemplate.getForEntity(webService + "sortinghat", String.class);
        var gson = new Gson();
        return gson.fromJson(response.getBody(), Student.class);
    }

    public static House findHouse(Student student) {
        var restTemplate = new RestTemplate();
        var response = restTemplate.getForEntity(webService + "/house/" + student.getHouseId(), String.class);
        var gson = new Gson();
        return gson.fromJson(response.getBody(), House.class);
    }

}
