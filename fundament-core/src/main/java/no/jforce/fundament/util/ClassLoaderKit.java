package no.jforce.fundament.util;

import no.jforce.fundament.annotations.NotNull;

import java.io.InputStream;

/**
 * @author <a href="mailto:runepeter@gmail.com">Rune Peter Bj&oslash;rnstad</a>
 */
public final class ClassLoaderKit {

    private ClassLoaderKit() {
    }

    public static ClassLoader getStandardClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static ClassLoader getFallbackClassLoader() {
        return ClassLoaderKit.class.getClassLoader();
    }

    public static InputStream getResourceAsStream( @NotNull final String resource ) {

        InputStream stream = getStandardClassLoader().getResourceAsStream( resource );

        if ( stream == null ) {
            stream = getFallbackClassLoader().getResourceAsStream( resource );
        }

        if ( stream == null ) {
            throw new IllegalStateException( "Cannot load resource '" + resource + "' as InputStream." );
        }

        return stream;
    }

    public static Object createNewInstance( @NotNull final String className ) {
        Class clazz;
        Object newInstance;
        try {
            clazz = Class.forName( className, true, getStandardClassLoader() );
        } catch ( ClassNotFoundException e ) {
            //try fallback
            try {
                clazz = Class.forName( className, true, getFallbackClassLoader() );
            } catch ( ClassNotFoundException ex ) {
                throw new RuntimeException( "Unable to load class " + className +
                        ". Initial cause was " + e.getMessage(), e );
            }
        }

        try {
            newInstance = clazz.newInstance();
        } catch ( IllegalAccessException e ) {
            throw new RuntimeException( "Unable to load class " + className +
                    ". Initial cause was " + e.getMessage(), e );
        } catch ( InstantiationException e ) {
            throw new RuntimeException( "Unable to load class " + className +
                    ". Initial cause was " + e.getMessage(), e );
        }
        return newInstance;
    }

}
