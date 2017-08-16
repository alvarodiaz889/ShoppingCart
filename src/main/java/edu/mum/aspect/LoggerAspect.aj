package edu.mum.aspect;

import edu.mum.email.EmailService;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by Sushan on 8/15/2017.
 */
@Component
@Aspect
public aspect LoggerAspect {

    @Autowired
    EmailService emailService;

    //private static Logger logger = Logger.getLogger(LoggerAspect.class);

    @After("execution(public void edu.mum.service.OrderService.saveOrder(..))")
    public void traceAfterMethod(){
        System.out.println("<-------from aspect------->");
        //logger.info("method= "+joinpoint.getSignature().getName());
       // emailService.sendEmail("sushan.baskota13@gmail.com","About mail checking,EA project", "This is message generted from Aspect.");
    }

}

