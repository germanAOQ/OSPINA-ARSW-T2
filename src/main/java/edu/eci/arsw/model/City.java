package edu.eci.arsw.model;

public class City {
    
    String name;
    String temperatura;
    String sensacionTermica;
    String minTemperatura;
    String maxTemperatura;
    String presion;
    String humedad;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getSensacionTermica() {
        return sensacionTermica;
    }

    public void setSensacionTermica(String sensacionTermica) {
        this.sensacionTermica = sensacionTermica;
    }

    public String getMinTemperatura() {
        return minTemperatura;
    }

    public void setMinTemperatura(String minTemperatura) {
        this.minTemperatura = minTemperatura;
    }

    public String getMaxTemperatura() {
        return maxTemperatura;
    }

    public void setMaxTemperatura(String maxTemperatura) {
        this.maxTemperatura = maxTemperatura;
    }

    public String getPresion() {
        return presion;
    }

    public void setPresion(String presion) {
        this.presion = presion;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

	public City(String name, String temperatura, String sensacionTermica, String minTemperatura, String maxTemperatura,
			String presion, String humedad) {
		this.name = name;
		this.temperatura = temperatura;
		this.sensacionTermica = sensacionTermica;
		this.minTemperatura = minTemperatura;
		this.maxTemperatura = maxTemperatura;
		this.presion = presion;
		this.humedad = humedad;
    }
}