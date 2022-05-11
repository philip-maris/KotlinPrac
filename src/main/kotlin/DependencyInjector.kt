import java.io.FileInputStream
import java.util.*

class DependencyInjector {

    fun getProperties() : Properties {
        val props =  Properties()
        try {
            val fis = FileInputStream("db.properties");
            props.load(fis);
        } catch ( e : Exception) {
            e.printStackTrace();
        }
        return props
    }

    fun getConnection( properties : Properties ) = DbConnection(properties)

//    fun getDao() : Dao = DaoImpl(getConnection())
    fun getQuery(act : String ) : String {
        return when(act){

            else -> "fgf"
        }
    }

}