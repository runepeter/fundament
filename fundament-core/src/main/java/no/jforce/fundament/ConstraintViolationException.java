package no.jforce.fundament;

import no.jforce.fundament.annotations.NotNull;

/**
 * @author <a href="mailto:runepeter@gmail.com">Rune Peter Bj&oslash;rnstad</a>
 */
public class ConstraintViolationException extends RuntimeException {

    public ConstraintViolationException( @NotNull String message ) {
        super( message );
    }

}
