package demo;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ShoppingCart {
    public void checkout(String status){
        // Logging
        // Authentication and authorisation
        // Sanitise the data
        System.out.println("Checkout method called" );
    }

    public Date checkoutTime() {
        return new Date();
    }
}
