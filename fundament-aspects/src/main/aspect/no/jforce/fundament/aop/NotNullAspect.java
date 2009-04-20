package no.jforce.fundament.aop;

import no.jforce.fundament.ConstraintViolationException;
import no.jforce.fundament.aop.util.NotNullCheck;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.ConstructorSignature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author <a href="mailto:runepeter@gmail.com">Rune Peter Bj&oslash;rnstad</a>
 */
@Aspect
public class NotNullAspect {

    /**
     * Constructor Pointcuts:
     */
    @Pointcut( "execution(*.new(@no.jforce.fundament.annotations.NotNull (*), ..))" )
    public void newInstance1() {}

    @Pointcut( "execution(*.new(*,@no.jforce.fundament.annotations.NotNull (*), ..))" )
    public void newInstance2() {}

    @Pointcut( "execution(*.new(*, *,@no.jforce.fundament.annotations.NotNull (*), ..))" )
    public void newInstance3() {}

    @Pointcut( "execution(*.new(.., @no.jforce.fundament.annotations.NotNull (*)))" )
    public void newInstance4() {}

    @Pointcut( "newInstance1() || newInstance2() || newInstance3() || newInstance4()" )
    public void constructorWithNotNull() {}

    /**
     * Method-call Pointcuts:
     */
    @Pointcut( "execution(* *.*(@no.jforce.fundament.annotations.NotNull (*), ..))" )
    public void methodCall1() {}

    @Pointcut( "execution(* *.*(*,@no.jforce.fundament.annotations.NotNull (*), ..))" )
    public void methodCall2() {}

    @Pointcut( "execution(* *.*(*, *,@no.jforce.fundament.annotations.NotNull (*), ..))" )
    public void methodCall3() {}

    @Pointcut( "execution(* *.*(.., @no.jforce.fundament.annotations.NotNull (*)))" )
    public void methodCall4() {}

    @Pointcut( "methodCall1() || methodCall2() || methodCall3() || methodCall4()" )
    public void methodCallWithNotNull() {}

    /**
     * Method-return pointcuts:
     */
    @Pointcut( "execution(@no.jforce.fundament.annotations.NotNull * *.*(..))" )
    public void methodReturningNotNull() {}

    /**
     * "Constructor with @no.jforce.fundament.annotations.NotNull"-advice
     *
     * @param joinPoint the JoinPoint that was picked up by the pointcut.
     */
    @Before( "constructorWithNotNull()" )
    public void beforeConstructor( final JoinPoint joinPoint ) {

        ConstructorSignature signature = (ConstructorSignature) joinPoint.getStaticPart().getSignature();
        Constructor constructor = signature.getConstructor();

        String[] names = signature.getParameterNames();
        Class[] types = signature.getParameterTypes();

        Object[] args = joinPoint.getArgs();

        Annotation[][] annotations = constructor.getParameterAnnotations();

        new NotNullCheck( annotations, args, names, types ).handle();
    }

    /**
     * "Method-call with @no.jforce.fundament.annotations.NotNull parameter(s)"-advice.
     *
     * @param joinPoint the JoinPoint that was picked up by the pointcut.
     */
    @Before( "methodCallWithNotNull()" )
    public void beforeMethodCall( final JoinPoint joinPoint ) {

        MethodSignature signature = (MethodSignature) joinPoint.getStaticPart().getSignature();
        Method method = signature.getMethod();

        String[] names = signature.getParameterNames();
        Class[] types = signature.getParameterTypes();

        Object[] args = joinPoint.getArgs();

        Annotation[][] annotations = method.getParameterAnnotations();

        new NotNullCheck( annotations, args, names, types ).handle();
    }

    /**
     * "Execution of method with @no.jforce.fundament.annotations.NotNull return value"-advice.
     *
     * @param returnedValue value returned by the actual method invocation.
     */
    @AfterReturning( pointcut = "methodReturningNotNull()", returning = "returnedValue" )
    public void methodReturning( final Object returnedValue ) {
        if ( returnedValue == null ) {
            throw new ConstraintViolationException( "Methods' return value is in violation of the @no.jforce.fundament.annotations.NotNull constraint." );
        }
    }

}
