

class PersonService(val personRepository: PersonRepository) {

    fun create(person: Person) {

        personRepository.save(
                person.copy(
                        firstName = person.firstName.toLowerCase(),
                        lastName = person.lastName.toLowerCase()
                ))
    }

}