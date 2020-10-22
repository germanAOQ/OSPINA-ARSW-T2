package edu.eci.arsw.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.services.ClimaStatsServices;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;

@RestController
@RequestMapping("/clima")
public class CoronavirusStatsController {

    @Autowired
    ClimaStatsServices climaServices;

    /**
     * Permite obtener datos acerca de una ciudad especifica
     * @param city Ciudad a consultar su clima
     * @return Información acerca del clima de la ciudad
     */
    @GetMapping("{city}")
    public ResponseEntity<?> getCasesByCountry(@PathVariable String city) {
        try {
            String data = new Gson().toJson(climaServices.getClimaByCity(city));
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Recurso no encontrado", HttpStatus.NOT_FOUND);
        }
    }

}
