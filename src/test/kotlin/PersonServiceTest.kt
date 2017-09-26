import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class PersonServiceTest {


    @Test
    fun `create should lowercase name and persist`() {
        val service = PersonService()

        service.create(Person(123, "firstName", "lastName"))

    }
}