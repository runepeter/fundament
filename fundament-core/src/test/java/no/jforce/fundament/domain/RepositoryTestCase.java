package no.jforce.fundament.domain;

import static org.testng.Assert.assertNotNull;
import no.jforce.fundament.annotations.NotNull;

import org.testng.annotations.Test;

/**
 * @author <a href="mailto:runepeter@gmail.com">Rune Peter Bj&oslash;rnstad</a>
 */
public class RepositoryTestCase {

	@Test
	public void createInstanceUsingFactory() throws Exception {

		TestRepository repository = Repository.Factory.create(TestRepository.class);
		assertNotNull(repository);

	}

	/**
	 * @author <a href="mailto:runepeter@gmail.com">Rune Peter
	 *         Bj&oslash;rnstad</a>
	 */
	public static interface TestRepository extends Repository<TestEntity, Long> {

	}

	/**
	 * @author <a href="mailto:runepeter@gmail.com">Rune Peter
	 *         Bj&oslash;rnstad</a>
	 */
	public static class TestRepositoryImpl implements TestRepository {

		public TestEntity get(@NotNull Long entityId) {
			throw new UnsupportedOperationException("Implementation pending.");
		}

		public TestEntity save(@NotNull TestEntity entity) {
			throw new UnsupportedOperationException("Implementation pending.");
		}

		public void delete(@NotNull TestEntity entity) {
			throw new UnsupportedOperationException("Implementation pending.");
		}

	}

	/**
	 * @author <a href="mailto:runepeter@gmail.com">Rune Peter
	 *         Bj&oslash;rnstad</a>
	 */
	public static class TestEntity implements Entity<TestEntity, Long> {

		private final Long id;

		public TestEntity(Long id) {
			this.id = id;
		}

		public Long id() {
			return id;
		}

		public boolean equals(TestEntity otherEntity) {
			return id().equals(otherEntity.id());
		}

	}
}
