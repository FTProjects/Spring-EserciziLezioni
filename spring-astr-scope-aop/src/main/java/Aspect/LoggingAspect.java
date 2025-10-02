package Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect // Contrassegna la classe come un aspect fornendo le sue funzionalità
@Component // vogliamo un bean nel context
public class LoggingAspect {
    // un oggetto di java che permette di loggare in console
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    // il metodo che intercetta altri metodi (joinPoint)
    // tramite @Around possiamo svolgere operazioni prima dopo e durante l'esecuzione di metodi intercettati
    // l'espressione dentro l'annotazione è un Pointcut che definisce QUALI metodi intercettare
    // execution = all'esecuzione dei metodi
    // * = che tornano qualsiasi tipo di dato
    // org.example.service = in questo package
    // .* = tutte le classi
    // .* = tutti i metodi
    // (..) = accettano qualsiasi tipo di input
    @Around("execution(* service.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        // eseguo logiva prima dell'esecuzione del metodo
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        //logger.info("AOP - Metodo " + methodName + " chiamato con parametri " + Arrays.asList(args));
        System.out.println("AOP - Metodo " + methodName + " chiamato con parametri " + Arrays.asList(args));

        Object retByMethod = joinPoint.proceed(); // eseguo il metodo originale

        // eseguo logica dopo l'esecuzione del metodo
//        logger.warning("AOP - Metodo eseguito, ha resituito " + retByMethod);
        System.out.println("AOP - Metodo eseguito, ha resituito " + retByMethod);
        return retByMethod; // ritorniamo l'oggetto che avrebbe tornato il metodo originale
    }
}
