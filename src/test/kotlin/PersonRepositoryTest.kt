import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import java.sql.Connection
import java.sql.DriverManager


class InMemoryPersonRepositoryTest {

    @Test
    fun `should store and retrieve people`() {

        val repo = InMemoryPersonRepository()
        val person = Person(123, "firstName", "lastName")

        repo.save(person)
        assertThat(repo.get(123), equalTo(person))
    }

}
