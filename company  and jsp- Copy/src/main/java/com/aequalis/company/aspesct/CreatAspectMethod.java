package com.aequalis.company.aspesct;

import com.aequalis.company.teamleader.controller.TlResource;
import com.aequalis.company.teamleader.dto.TlDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class CreatAspectMethod {

   @Pointcut("execution(* com.aequalis.company.teamleader.controller.*.*(..))")
  public  void loggingPointcut(){}

    @Before("execution(* com.aequalis.company.teamleader.controller.*.*(..))")//point-cut expression
    public void before(JoinPoint joinPoint){
         log.info("Before method invoked::"+joinPoint.getSignature());
    }

    @After("loggingPointcut()")
    public void after(JoinPoint joinPoint){
        log.info("after method invoked::"+joinPoint.getSignature());
   }


    /*@AfterReturning(value ="execution(* com.aequalis.company.teamleader.controller.*.*(..))",
    returning = "tlDto")
    public void after(JoinPoint joinPoint, TlDto tlDto){
        log.info("after method invoked::"+tlDto);
    }*/

    /*@AfterThrowing(value ="execution(* com.aequalis.company.teamleader.controller.*.*(..))",
            throwing = "e")
    public void after(JoinPoint joinPoint, Exception e){

        log.info("after method invoked::"+e.getMessage());
    }*/

  /* @Around("loggingPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Before method invoked::"+joinPoint.getArgs()[0]);
         TlDto object=(TlDto)joinPoint.proceed();

              log.info("After method invoked::"+object);

        return object;
    }*/
}
