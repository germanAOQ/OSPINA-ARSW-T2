package edu.eci.arsw.connection;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public interface HttpConnectionService {
    public HttpResponse<JsonNode> getClimaByCiudad(String city); 
	
}
