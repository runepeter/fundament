package no.jforce.fundament.aop.util;

import no.jforce.fundament.ConstraintViolationException;

import java.lang.annotation.Annotation;

public class NotNullCheck {

    private final Annotation[][] annotations;
    private final Object[] arguments;
    private final String[] names;
    private final Class[] types;

    public NotNullCheck( final Annotation[][] annotations,
                         final Object[] arguments, final String[] names, final Class[] types ) {
        this.annotations = annotations;
        this.arguments = arguments;
        this.names = names;
        this.types = types;
    }

    public void handle() {
        for ( int i = 0; i < annotations.length; i++ ) {

            boolean notNullPresent = AnnotationKit
                    .isNotNullPresent( annotations[i] );
            boolean argIsNull = arguments[i] == null;

            if ( notNullPresent && argIsNull ) {
                throw new ConstraintViolationException(
                        String
                                .format(
                                "Argument [%s %s] is in violation of the @NotNull constraint.",
                                types[i].getSimpleName(), names[i] ) );
            }

        }
    }

}
