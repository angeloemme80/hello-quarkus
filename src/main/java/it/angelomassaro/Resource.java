package it.angelomassaro;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class Resource {

    @Inject
    @ConfigProperty(name="quarkus.application.name", defaultValue="VALORE-DI-DEFAULT")
    private String applicationName;

    @GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    public Person hello() {
        Person person = new Person("Angelo", "Massaro");
        return person;
    }

    @GET
    @Path("/app-name")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAppName() {
        return applicationName;
    }

}
