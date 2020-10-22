package edu.eci.arsw.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.protocol.HttpService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.connection.HttpConnectionService;
import edu.eci.arsw.model.City;
import edu.eci.arsw.services.ClimaStatsServices;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

@Service
public class ClimaStatsServicesImpl implements ClimaStatsServices {

    @Autowired
    HttpConnectionService httpConnectionService;

    @Override
    public City getClimaByCity(String city) {
        HttpResponse<JsonNode> temp = httpConnectionService.getClimaByCiudad(city);
        String name = city;
        String temperatura = temp.getBody().getObject().getJSONObject("main").getString("temp");
        String sensacionTermica = temp.getBody().getObject().getJSONObject("main").getString("feels_like");
        String minTemperatura = temp.getBody().getObject().getJSONObject("main").getString("temp_min");
        String maxTemperatura = temp.getBody().getObject().getJSONObject("main").getString("temp_max");
        String presion = temp.getBody().getObject().getJSONObject("main").getString("pressure");
        String humedad = temp.getBody().getObject().getJSONObject("main").getString("humidity");

        City ciudad =  new City(name, temperatura, sensacionTermica, minTemperatura, maxTemperatura, presion, humedad);

        return ciudad;

    }

}
