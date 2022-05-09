import com.google.gson.Gson
import java.io.FileReader
import java.sql.ResultSet
import java.sql.Statement
import javax.sql.DataSource


class Dao {


    var bs : DataSource = DataSource
    private val connection = DbConnection()
    var stmt = connection.statement
    var rs = connection.resultSet
    
    private val gson = Gson()

    fun addStudent(student: Student) {
        try {
            val addQuery = " INSERT INTO `student` (`firstname`, `lastname`,`age`) VALUES (\"${student.firstName}\",\"${student.lastName}\",${student.age});"
           stmt!!.executeUpdate(addQuery)
            println("added ${student.firstName}")
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun retrieveStudents() {
        try {
            //what's the use of this statement
            val viewQuery = " SELECT * FROM student;"
            if (stmt!!.execute(viewQuery)) {
                rs = stmt!!.resultSet
                println("FIRSTNAME\tLASTNAME\tAGE")

            }
            var studentList = ArrayList<Student>()
            while (rs!!.next()) {
                var s = Student(
                    rs!!.getString(1),
                    rs!!.getString(2),
                    rs!!.getInt(3)
                )
                studentList.add(s)

            }
            println(convertToJson(studentList))
            var a = convertFromJson(convertToJson(studentList))
            for (i in a) println(i)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun deleteStudent(student: Student) {
        val deleteQuery = "DELETE FROM student WHERE (firstName = \"${student.firstName}\");"
        try{
            stmt!!.executeUpdate(deleteQuery)
        }catch (e : Exception){
            e.printStackTrace()
        }

    }

    fun updateStudent(student: Student) {
        val updateQuery = "UPDATE student SET age = 76 WHERE (firstName=\"${student.firstName}\");"
        try{
            stmt!!.executeUpdate(updateQuery)
        }catch (e : Exception){
            e.printStackTrace()
        }
    }
    
    fun convertToJson(studentList : ArrayList<Student>): String = gson.toJson(studentList)
    fun convertFromJson(jsonString : String): Array<Student> = gson.fromJson(jsonString, Array<Student> :: class.java)



    fun addStudent(){
        try {
            val student: Array<Student> = gson.fromJson(FileReader("./src/main/resources/Student.json"), Array<Student>::class.java)

//            var  = convertFromJson(jsonString)
            for (i in student){
                val addQuery = " INSERT INTO `student` (`firstname`, `lastname`,`age`) VALUES (\"${i.firstName}\",\"${i.lastName}\",${i.age});"
                stmt!!.executeUpdate(addQuery)
                println("added ${i.firstName}")
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}