import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import java.sql.Connection
import java.sql.DriverManager


abstract class PersonRepositoryTestContract {

    @Test
    fun `should store and retrieve people`() {

        val repo = InMemoryPersonRepository()
        val person = Person(123, "firstName", "lastName")

        repo.save(person)
        assertThat(repo.get(123), equalTo(person))
    }

    abstract fun repo(): PersonRepository
}


class InMemoryPersonRepositoryTest : PersonRepositoryTestContract() {
    override fun repo() = InMemoryPersonRepository()
}

class SqlPersonRepositoryTest : PersonRepositoryTestContract() {

    lateinit var conn: Connection

    @Before
    fun setUp() {
        Class.forName("org.h2.Driver")
        conn = DriverManager.getConnection("jdbc:h2:mem:")
        conn.createStatement().execute("""
            CREATE TABLE people (
                ID int,
                firstName varchar(100),
                lastName varchar(100)
            );
        """)
    }

    override fun repo() = SqlPersonRepository(conn)
}

