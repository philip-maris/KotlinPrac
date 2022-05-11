import java.io.FileReader

data class Student (var firstName :String, var lastName :String, var age :Int)



fun main() {
    val injector = DependencyInjector()

    val dao = DaoImpl(injector.getConnection(injector.getProperties()))
//    var db = DbConnection(injector.getProperties())

    val s1 = Student("The ", "Boy", 12)
    val s3 = Student("frank ", "oceans", 12)

    while (true) {
        when (action()) {
            1 -> dao.retrieveStudents()
            2 -> dao.addStudent()
            3 -> dao.updateStudent(s3)
            4 -> dao.deleteStudent(s1)
            5 -> {
                println("Thank you")
                return
            };
            else -> " ERROR !!"
        }
    }
}

fun action(): Int {
    println("Choose an operation")
    println("1 => View all students")
    println("2 => Add student")
    println("3 => Edit student")
    println("4 => Delete student")
    println("5 => EXIT\n::")

    return readLine()!!.toInt()
}