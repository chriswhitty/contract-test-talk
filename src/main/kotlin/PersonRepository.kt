interface PersonRepository {

    fun save(person: Person)

    fun get(id: Int): Person?
}