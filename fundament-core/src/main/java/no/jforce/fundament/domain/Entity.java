package no.jforce.fundament.domain;

import java.io.Serializable;

/**
 * @author <a href="mailto:runepeter@gmail.com">Rune Peter Bj&oslash;rnstad</a>
 */
public interface Entity<I extends Serializable> {

    I getId();

}
