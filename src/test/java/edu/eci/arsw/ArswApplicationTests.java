package edu.eci.arsw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import edu.eci.arsw.services.impl.ClimaStatsServicesImpl;

@SpringBootTest
class ArswApplicationTests {


	@Autowired
	HttpConnectionService ht;

	@Autowired
	ClimaStatsServicesImpl ci;

	

	@Test
	public void shouldWork() throws UnirestException, JSONException {
		//List<String> a=t.totalNumbers();
		//HashMap<String,List<HashMap<String,String>>> b=t.statsNumbers();
		//System.out.println(a.toString());
		//System.out.println(b.toString());

		//System.out.println(cs.countryStatsNumbers("Colombia"));

		System.out.println(ci.getClimaByCity("London").getPresion());

		//System.out.println(ht.statsNumbers().getBody().getObject().getJSONObject("data").getJSONArray("covid19Stats").getJSONObject(0).getString("recovered"));
		
	}

}
