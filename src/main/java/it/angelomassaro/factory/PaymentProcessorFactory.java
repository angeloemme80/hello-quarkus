package it.angelomassaro.factory;

import it.angelomassaro.factory.classiconcrete.BancaIngDirect;
import it.angelomassaro.factory.classiconcrete.CreditCardPaymentProcessor;
import it.angelomassaro.factory.classiconcrete.PaypalPaymentProcessor;
import it.angelomassaro.factory.interfaces.PaymentProcessor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class PaymentProcessorFactory {

    private final CreditCardPaymentProcessor creditCardPaymentProcessor;
    private final PaypalPaymentProcessor paypalPaymentProcessor;
    private final BancaIngDirect bancaIngDirect;


    public PaymentProcessorFactory(CreditCardPaymentProcessor creditCardPaymentProcessor,
                                   PaypalPaymentProcessor paypalPaymentProcessor,
                                   BancaIngDirect bancaIngDirect) {
        this.creditCardPaymentProcessor = creditCardPaymentProcessor;
        this.paypalPaymentProcessor = paypalPaymentProcessor;
        this.bancaIngDirect = bancaIngDirect;
    }


    public PaymentProcessor createPaymentProcessor(String paymentMethod) {
        if (paymentMethod.equalsIgnoreCase("creditcard")) {
            return creditCardPaymentProcessor;
        } else if (paymentMethod.equalsIgnoreCase("paypal")) {
            return paypalPaymentProcessor;
        } else if (paymentMethod.equalsIgnoreCase("ing")) {
            return bancaIngDirect;
        }
        throw new IllegalArgumentException("Invalid payment method: " + paymentMethod);
    }
}