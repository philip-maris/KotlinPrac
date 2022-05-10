import java.io.Closeable
import java.sql.*
import java.util.*


class DbConnection : Closeable {

     var conn: Connection? = null
    private val user = "root"
    private val url =
        "jdbc:mysql://localhost:3306/users?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private val password = "12345"

    var statement: Statement? = null
    var resultSet : ResultSet? = null

    init {
        val connectionProps = Properties()
        connectionProps["user"] = user
        connectionProps["password"] = password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, connectionProps)
            println("connected")
            statement = conn!!.createStatement()


        } catch (e: Exception) {
            println(" not connected")
            e.printStackTrace()
        }

    }

    override fun close() {
        conn!!.close()
    }
}