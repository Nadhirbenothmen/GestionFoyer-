package tn.esprit.spring.seance1.Configurations;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before("execution(* tn.esprit.spring.seance1.ServicesIMP.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
    @After("execution(* tn.esprit.spring.seance1.ServicesIMP.*.*(..))")
    public void exit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of method " + name + " : ");
    }
    @AfterReturning("execution(* tn.esprit.spring.seance1.ServicesIMP.*.*(..))")
    public void exit1(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of  method without error " + name + " : ");
    }
    @AfterThrowing("execution(* tn.esprit.spring.seance1.ServicesIMP.*.*(..))")
    public void exit2(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of method with error " + name + " : ");
    }

}
