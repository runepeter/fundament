package no.jforce.fundament.service;

import no.jforce.fundament.annotations.NotNull;

/**
 * @author <a href="mailto:runepeter@gmail.com">Rune Peter Bj&oslash;rnstad</a>
 */
public interface Service {

    static class Locator implements no.jforce.fundament.pattern.Locator {

        public static <S extends Service> S get( @NotNull final Class<S> serviceClass ) {
            return null;
        }

    }

}
