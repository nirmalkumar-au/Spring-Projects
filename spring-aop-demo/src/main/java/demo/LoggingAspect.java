package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* demo.ShoppingCart.*(..))" )
    public void beforeLogger(JoinPoint jp) {
        System.out.println("Before Logger method");
        System.out.println("Method-> " + jp.getSignature());
        for ( Object argument : jp.getArgs() ) {
            System.out.println("Method argument->"+ argument.toString());
        }
    }

    @After("execution(* *.*.*(..))")
    public void afterLogger() {
        System.out.println("After Logger method");
    }

    @Pointcut("execution(* demo.ShoppingCart.checkoutTime(..))")
    public void afterReturningPointCut(){}

    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "returnValue")
    public void afterReturning(Date returnValue) {
          System.out.println("Returning value -> " + returnValue);
    }
}
