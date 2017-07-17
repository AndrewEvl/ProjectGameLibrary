package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 15.07.2017.
 */
@Component
@Aspect
public class Logger {

    @Before("execution(* *(..)) && @annotation(service.Loggable)")
    public void logBefore(JoinPoint joinPoint) {

    }
}
