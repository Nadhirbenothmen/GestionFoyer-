package tn.esprit.spring.seance1.Configurations;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class PerformanceAspect {
//    @Around("execution(* tn.esprit.spring.seance1.ServicesIMP.*.*(..))")
//    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
//        long start = System.currentTimeMillis();
//        Object obj = pjp.proceed();
//        long elapsedTime = System.currentTimeMillis() - start;
//        log.info("Method execution time: " + elapsedTime + " milliseconds.");
//        return obj;
//    }
}
