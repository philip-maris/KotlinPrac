import com.google.gson.Gson

interface Dao{
    fun addStudent()
    fun retrieveStudents()
    fun updateStudent(s : Student)
    fun deleteStudent(s : Student)
}


class DaoImpl (connection : DbConnection ): Dao {


    var stmt = connection.statement
    var rs = connection.resultSet
    
    private val gson = Gson()

    override fun addStudent() {

        try {
            println("Enter details in this formart => firstname lastname age")
            var (fname,lname,age) = readLine()!!.split(' ')
            val addQuery = " INSERT INTO `student` (`firstname`, `lastname`,`age`) VALUES (\"${fname}\",\"${lname}\",${age});"
            stmt!!.executeUpdate(addQuery)
            println("added ${fname}")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun retrieveStudents() {
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
            for (i in a) println(i); println()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun deleteStudent(student: Student) {
        println(" Enter the first name of the student ")
        var name = readLine()
        val deleteQuery = "DELETE FROM student WHERE (firstName = \"$name\");"
        try{
            stmt!!.executeUpdate(deleteQuery)
        }catch (e : Exception){
            e.printStackTrace()
        }

    }

    override  fun updateStudent(student: Student) {

  /*      print("Enter firstname of the student to be updated : ")
        var firstname = readLine()
        println("Enter what to what to be edited and its new value ")
        println("Format => firstname or ")*/
        val updateQuery = "UPDATE student SET age = 76 WHERE (firstName=\"${student.firstName}\");"
        try{
            stmt!!.executeUpdate(updateQuery)
        }catch (e : Exception){
            e.printStackTrace()
        }
    }
    
    fun convertToJson(studentList : ArrayList<Student>): String = gson.toJson(studentList)
    fun convertFromJson(jsonString : String): Array<Student> = gson.fromJson(jsonString, Array<Student> :: class.java)

}


/*    fun addStudent(){
        try {
            val student: Array<Student> = gson.fromJson(FileReader("./src/main/resources/Student.json"), Array<Student>::class.java)

            for (i in student){
                val addQuery = " INSERT INTO `student` (`firstname`, `lastname`,`age`) VALUES (\"${i.firstName}\",\"${i.lastName}\",${i.age});"
                stmt!!.executeUpdate(addQuery)
                println("added ${i.firstName}")
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }*/