package no.jforce.fundament.util;

import java.net.URL;

/**
 * @author <a href="mailto:runepeter@gmail.com">Rune Peter Bj&oslash;rnstad</a>
 */
public class ClassPathKit {

    private ClassPathKit() {}

    public static URL getResource( final String resourceName, final Class callingClass ) {

        ClassLoader[] classLoaders = new ClassLoader[]{
                Thread.currentThread().getContextClassLoader(),
                ClassPathKit.class.getClassLoader(),
                callingClass.getClassLoader()
        };

        URL resourceUrl = null;

        for ( ClassLoader classLoader : classLoaders ) {

            resourceUrl = (classLoader != null ? classLoader.getResource( resourceName ) : null);
            if (resourceUrl != null) {
                break;
            }

        }

        return resourceUrl;
    }

}
