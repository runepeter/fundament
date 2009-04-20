package no.jforce.fundament.domain;

import org.testng.annotations.Test;import static org.testng.Assert.assertNotNull;
import no.jforce.fundament.annotations.NotNull;

import java.io.Serializable;

/**
 * @author <a href="mailto:runepeter@gmail.com">Rune Peter Bj&oslash;rnstad</a>
 */
public class RepositoryTestCase {

    @Test
    public void createInstanceUsingFactory() throws Exception {

        TestRepository repository = Repository.Factory.create( TestRepository.class );
        //assertNotNull(repository);

    }

    public static class TestRepository implements Repository<TestEntity, Long> {

        public TestEntity get( @NotNull Long entityId ) {
            throw new UnsupportedOperationException( "Implementation pending." );
        }

        public void save( @NotNull TestEntity entity ) {
            throw new UnsupportedOperationException( "Implementation pending." );
        }

        public void delete( @NotNull TestEntity entity ) {
            throw new UnsupportedOperationException( "Implementation pending." );
        }
        
    }

    public static class TestEntity implements Entity<Long> {

        private final Long id;

        public TestEntity( Long id ) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

    }

}
