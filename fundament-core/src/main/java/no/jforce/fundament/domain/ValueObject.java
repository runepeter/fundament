package no.jforce.fundament.domain;

/**
 * ValueObject's are equal when all attributes are equal. They don't have an identity.
 *
 * @author <a href="mailto:runepeter@gmail.com">Rune Peter Bj&oslash;rnstad</a>
 */
public interface ValueObject<V extends ValueObject> {

    /**
     * Compares attributes for equality.
     *
     * @param otherValueObject the other {@code ValueObject} to compare with.
     * @return {@code true} if the given value object's and this value object's attributes are the same.
     */
    boolean hasSameValueAs( V otherValueObject );

}
