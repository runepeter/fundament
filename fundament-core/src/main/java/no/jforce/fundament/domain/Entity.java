package no.jforce.fundament.domain;

/**
 * An {@code Entity}'s uniqueness is determined by its identifier.
 * 
 * @author <a href="mailto:runepeter@gmail.com">Rune Peter Bj&oslash;rnstad</a>
 * @param <E>
 *            the type of the {@code Entity}.
 * @param <I>
 *            the type of the {@code Entity} identifier.
 */
public interface Entity<E extends Entity, I> {

	/**
	 * @return the {@code Entity} identifier.
	 */
	I id();

	/**
	 * Compare by identity (and not attributes).
	 * 
	 * @param otherEntity
	 *            the other {@code Entity} to compare with.
	 * @return {@code true} if the identities are the same, regardless of the
	 *         other attributes.
	 */
	boolean equals(E otherEntity);

}
