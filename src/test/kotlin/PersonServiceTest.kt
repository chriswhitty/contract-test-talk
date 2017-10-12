import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class PersonServiceTest {


    @Test
    fun `create should lowercase name and persist`() {
        val personRepository = InMemoryPersonRepository()
        val service = PersonService(personRepository)

        service.create(Person(123, "firstName", "lastName"))

        val actualPerson = personRepository.get(123)
        assertThat(actualPerson, equalTo(Person(123, "firstname", "lastname")))
    }
}