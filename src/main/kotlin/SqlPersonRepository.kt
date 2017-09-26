import java.sql.Connection

class SqlPersonRepository(val conn: Connection) : PersonRepository {

    override fun get(id: Int): Person? {
        val statement = conn.prepareStatement("SELECT * FROM people WHERE ID = (?);")
        statement.setInt(1, id)

        val resultSet = statement.executeQuery()
        resultSet.next()

        return Person(
                id = resultSet.getInt(1),
                firstName = resultSet.getString(2),
                lastName = resultSet.getString(3)
        )
    }

    override fun save(person: Person) {
        val statement = conn.prepareStatement("INSERT INTO people VALUES(?, ?, ?);")
        statement.setInt(1, person.id)
        statement.setString(2, person.firstName)
        statement.setString(3, person.lastName)
        statement.execute()
    }

}