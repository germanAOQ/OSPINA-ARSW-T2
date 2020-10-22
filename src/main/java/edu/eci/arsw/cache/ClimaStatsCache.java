package edu.eci.arsw.cache;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import edu.eci.arsw.model.City;


@Service
public class ClimaStatsCache {
    private HashMap<String,City> memoriaClima = new HashMap<String,City>();

    public void saveCity(String ciudad, City city){
        memoriaClima.put(ciudad, city);
    }

    public HashMap<String,City> getMemoriaClima(){
        return memoriaClima;
    }

}
