package it.angelomassaro.factory.classiconcrete;

import it.angelomassaro.factory.interfaces.PaymentProcessor;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class BancaIngDirect implements PaymentProcessor {


    @Override
    public String processPayment() {
        return "Pagamanto effettuato con: ING DIRECT";
    }
}
