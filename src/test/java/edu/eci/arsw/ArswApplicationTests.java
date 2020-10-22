package edu.eci.arsw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import edu.eci.arsw.connection.HttpConnectionService;
import edu.eci.arsw.model.City;
import edu.eci.arsw.services.impl.ClimaStatsServicesImpl;

@SpringBootTest
class ArswApplicationTests {


	@Autowired
	HttpConnectionService ht;

	@Autowired
	ClimaStatsServicesImpl ci;

	@Test
	public void shouldGetCityInformationService() throws JSONException {
		HttpResponse<JsonNode> temp = ht.getClimaByCiudad("London");
        String name = "London";
        String temperatura = Double.toString(temp.getBody().getObject().getJSONObject("main").getDouble("temp"));
        String sensacionTermica = Double
                    .toString(temp.getBody().getObject().getJSONObject("main").getDouble("feels_like"));
        String minTemperatura = Double
                    .toString(temp.getBody().getObject().getJSONObject("main").getDouble("temp_min"));
        String maxTemperatura = Double
                    .toString(temp.getBody().getObject().getJSONObject("main").getDouble("temp_max"));
        String presion = String.valueOf(temp.getBody().getObject().getJSONObject("main").getLong("pressure"));
        String humedad = String.valueOf(temp.getBody().getObject().getJSONObject("main").getLong("humidity"));

		City ciudad = new City(name, temperatura, sensacionTermica, minTemperatura, maxTemperatura, presion, humedad);


		City cityObtenido = ci.getClimaByCity("London");
		assertTrue(ciudad.toString().equals(cityObtenido.toString()));
	}


}
