package com.nurgunmakarov.demo1.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Pointcut("@annotation(Log)")
    public void annotateLoggerMethod() {
    }

    @Around("@annotation(Log)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        logger.info("[AROUND]" + joinPoint.getSignature() + " выполнен за " + executionTime + "мс");
        return proceed;
    }

    @Before("annotateLoggerMethod()")
    public void logMethodCallWithParam(JoinPoint joinPoint) {
        logger.info("[BEFORE]Название метода: " + joinPoint.getSignature().getName() +
                " с параметрами: " + CollectionUtils.arrayToList(joinPoint.getArgs()));
    }

    @After("annotateLoggerMethod()")
    public void logMethodCall(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.log(Level.INFO, "[AFTER]Название метода: " + methodName);
    }

    @AfterReturning(pointcut = "execution(public String com.nurgunmakarov.demo1.controller.GreetingController.*(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("[AFTERRETURNING]Успешно завершился метод " + joinPoint.getSignature().getName());
    }
}
