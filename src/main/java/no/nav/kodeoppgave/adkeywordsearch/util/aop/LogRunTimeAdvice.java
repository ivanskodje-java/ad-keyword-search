package no.nav.kodeoppgave.adkeywordsearch.util.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@ConditionalOnExpression("${aspect.enabled:true}")
public class LogRunTimeAdvice {

  @Around("@annotation(logRunTime)")
  public Object executionTime(ProceedingJoinPoint point, LogRunTime logRunTime) throws Throwable {
    long startTime = System.currentTimeMillis();

    Object object = point.proceed();

    long timeDifference = System.currentTimeMillis() - startTime;

    log.info("[{}] {} took {} ms to execute", point.getSignature().getDeclaringTypeName(),
        point.getSignature().getName(), timeDifference);
    return object;
  }
}