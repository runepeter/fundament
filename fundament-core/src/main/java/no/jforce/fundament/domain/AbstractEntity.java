package no.jforce.fundament.domain;

import no.jforce.fundament.annotations.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * TODO runebjo: Document me.
 * 
 * @author <a href="mailto:runepeter@gmail.com">Rune Peter Bj&oslash;rnstad</a>
 */
public abstract class AbstractEntity<E extends Entity, I> implements Entity<E, I> {

	private final I id;

	public AbstractEntity(@NotNull final I id) {
		this.id = id;
	}

	/**
	 * Default constructor required for serialization.
	 */
	protected AbstractEntity() {
		this.id = null;
	}

	public I id() {
		return id;
	}

	@Override
	public boolean equals(@NotNull E otherEntity) {
		return otherEntity.id().equals(id());
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
