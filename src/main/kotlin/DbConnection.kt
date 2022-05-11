import java.io.Closeable
import java.sql.*
import java.util.*


class DbConnection (connectionProps : Properties) : Closeable {

    var conn: Connection? = null
    var statement: Statement? = null
    var resultSet : ResultSet? = null

    init {

        try {
            Class.forName(connectionProps["DRIVER_CLASS"].toString())
            conn = DriverManager.getConnection(connectionProps["URL"].toString(),connectionProps)
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