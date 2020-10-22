package edu.eci.arsw.cache;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import edu.eci.arsw.model.City;


@Service
public class ClimaStatsCache {
    private HashMap<String,City> memoriaClima = new HashMap<String,City>();

    /**
     * Permite guardar en cache una determinada ciudad 
     * @param ciudad nombre de la ciudad a guardar
     * @param city instancia de la clase City a gurdar
     */
    public void saveCity(String ciudad, City city){
        memoriaClima.put(ciudad, city);
    }

    /**
     * Permite obtener el cache
     * @return retorna el hashmap con el cual se realiza el cache
     */
    public HashMap<String,City> getMemoriaClima(){
        return memoriaClima;
    }

}
