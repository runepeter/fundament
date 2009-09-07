package no.jforce.fundament.domain;

import no.jforce.fundament.annotations.NotNull;
import no.jforce.fundament.util.ClassLoaderKit;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Interface for CRUD-based Repository-implementations.
 *
 * @param <E> the type of the {@link no.jforce.fundament.domain.Entity}-class that is stored in the repository.
 * @param <I> the type of the identifier used by {@code E}.
 */
public interface Repository<E extends Entity, I> {

    /**
     * Retrieves an entity (of type {@code E}) whose Id matches {@code entityId}.
     *
     * @param entityId the identifier of the entity to retrieve.
     * @return the found entity, or {@code null} if there was no entity with Id {@code entityId}.
     */
    E get( @NotNull I entityId );

    /**
     * Inserts entity {@code entity} into the repository, or makes an update the current store version of {@code entity}..
     *
     * @param entity the {@link no.jforce.fundament.domain.Entity} to store (or update).
     * @return the saved entity.
     */
    E save( @NotNull E entity );

    /**
     * Deletes entity {@code entity} from the repository.
     *
     * @param entity the {@link Entity} to delete.
     */
    void delete( @NotNull E entity );

    /**
     * Creates Repository-instances
     */
    static class Factory implements no.jforce.fundament.pattern.Factory<Repository> {

        public static <R extends Repository> R create( @NotNull Class<R> repositoryType ) {

            Properties properties = loadRepositoryConfig();

            return createRepositoryInstance( repositoryType, properties );
        }

        private static <R extends Repository> Properties loadRepositoryConfig() {
            Properties properties = new Properties();

            InputStream is = null;
            try {
                properties.load( is = ClassLoaderKit.getResourceAsStream( "META-INF/services/repositories.properties" ) );
            } catch ( IOException e ) {
                throw new IllegalStateException( "Unable to load Repository configuration.", e );
            } finally {
                IOUtils.closeQuietly( is );
            }
            return properties;
        }

        private static <R extends Repository> R createRepositoryInstance( Class<R> repositoryType, Properties properties ) {
            String className = properties.getProperty( repositoryType.getName() );
            if ( className == null ) {
                throw new IllegalStateException( "There is no configured implementation for Repository-interface '" + repositoryType.getName() + "'." );
            }

            //noinspection unchecked
            return (R) ClassLoaderKit.createNewInstance( className );
        }

    }

}

