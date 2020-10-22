package edu.eci.arsw.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.protocol.HttpService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.cache.ClimaStatsCache;
import edu.eci.arsw.connection.HttpConnectionService;
import edu.eci.arsw.model.City;
import edu.eci.arsw.services.ClimaStatsServices;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

@Service
public class ClimaStatsServicesImpl implements ClimaStatsServices {

    @Autowired
    HttpConnectionService httpConnectionService;

    @Autowired
    ClimaStatsCache climaCache;

    @Override
    public City getClimaByCity(String city) {

        City ciudad = null;

        if (climaCache.getMemoriaClima().containsKey(city)) {
            ciudad = climaCache.getMemoriaClima().get(city);
        } else {

            HttpResponse<JsonNode> temp = httpConnectionService.getClimaByCiudad(city);
            String name = city;
            String temperatura = Double.toString(temp.getBody().getObject().getJSONObject("main").getDouble("temp"));
            String sensacionTermica = Double
                    .toString(temp.getBody().getObject().getJSONObject("main").getDouble("feels_like"));
            String minTemperatura = Double
                    .toString(temp.getBody().getObject().getJSONObject("main").getDouble("temp_min"));
            String maxTemperatura = Double
                    .toString(temp.getBody().getObject().getJSONObject("main").getDouble("temp_max"));
            String presion = String.valueOf(temp.getBody().getObject().getJSONObject("main").getLong("pressure"));
            String humedad = String.valueOf(temp.getBody().getObject().getJSONObject("main").getLong("humidity"));

            ciudad = new City(name, temperatura, sensacionTermica, minTemperatura, maxTemperatura, presion, humedad);

            climaCache.saveCity(city, ciudad);

        }

        return ciudad;

    }

}
