package edu.eci.arsw.connection.impl;

import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

import edu.eci.arsw.connection.HttpConnectionService;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class HttpConnectionServiceImpl implements HttpConnectionService {

	/**
     * Permite obtener datos acerca de una ciudad especifica
     * @param city Ciudad a consultar su clima
     * @return Información acerca del clima de la ciudad
     */
	@Override
	public HttpResponse<JsonNode> getClimaByCiudad(String city) {
		HttpResponse<JsonNode> response=null;
		try {
			response = Unirest.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=fdb52316dc1666b0a57b5dbe9bd8ca46")
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
    
    
	
}
