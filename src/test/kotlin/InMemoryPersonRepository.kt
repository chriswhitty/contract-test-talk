
class InMemoryPersonRepository : PersonRepository {
    val people = mutableMapOf<Int, Person>()

    override fun save(person: Person) {
        people.put(person.id, person)
    }

    override fun get(id: Int): Person? {
        return people[id]
    }
}
