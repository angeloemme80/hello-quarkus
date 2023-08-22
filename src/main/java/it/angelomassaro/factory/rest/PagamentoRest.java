package it.angelomassaro.factory.rest;

import it.angelomassaro.factory.PaymentProcessorFactory;
import it.angelomassaro.factory.classiconcrete.CreditCardPaymentProcessor;
import it.angelomassaro.factory.classiconcrete.PaypalPaymentProcessor;
import it.angelomassaro.factory.interfaces.PaymentProcessor;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/pay")
public class PagamentoRest {

    @Inject
    PaymentProcessorFactory paymentProcessorFactory;

    @GET
    @Path("/{tipo}")
    @Produces(MediaType.APPLICATION_JSON)
    public String pagamento(@PathParam(value = "tipo") String tipopagamento) {
        PaymentProcessor pp = paymentProcessorFactory.createPaymentProcessor(tipopagamento);
        return pp.processPayment();
    }
}
