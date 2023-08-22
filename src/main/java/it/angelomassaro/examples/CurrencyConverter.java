package it.angelomassaro.examples;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/currencyService")
public class CurrencyConverter {
    @GET
    @Path("euro/{euro}")
    @Produces(MediaType.APPLICATION_JSON)
    public float dollarToEuro(@PathParam(value = "euro") float euro) {
        Conversion conversion = new Conversion(euro * 1.19f, euro);
        return  conversion.getDollar();
    }
    @GET
    @Path("dollar/{dollar}")
    @Produces(MediaType.APPLICATION_JSON)
    public float euroToDollar(@PathParam(value = "dollar") float dollar) {
        Conversion conversion = new Conversion(dollar, dollar / 1.19f);
        return  conversion.getEuro();
    }
    public static class Conversion {
        private float euro;
        private float dollar;
        public Conversion(float dollar, float euro) {
            this.euro = euro;
            this.dollar = dollar;
        }
        public void setEuro(float euro) { this.euro = euro;}
        public float getEuro(){ return euro;}
        public float getDollar() { return dollar; }
    }
}
