package no.jforce.fundament.domain;

import no.jforce.fundament.annotations.NotNull;
import no.jforce.fundament.domain.Entity;

import java.io.Serializable;

/**
 * Interface for CRUD-based Repository-implementations.
 *
 * @param <E> the type of the {@link no.jforce.fundament.domain.Entity}-class that is stored in the repository.
 * @param <I> the type of the identifier used by {@code E}.
 */
public interface Repository<E extends Entity<I>, I extends Serializable> {

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
     */
    void save( @NotNull E entity );

    /**
     * Deletes entity {@code entity} from the repository.
     *
     * @param entity the {@link Entity} to delete.
     */
    void delete( @NotNull E entity );

    static class Factory {

        static <R extends Repository> R create(@NotNull Class<R> repositoryType) {
            return null;
        }

    }

}

