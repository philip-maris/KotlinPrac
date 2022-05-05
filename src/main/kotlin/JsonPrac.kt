import com.google.gson.Gson
import java.io.FileReader

/*data class Person(var name: String, var age: Int, var birthday: Birthday, var address: Address)
data class Address(var country: String, var state: String)
data class Birthday(var day: Int, var month: Int, var year: Int)


fun main(){
    val newManAddress = Address(" Nigeria ", " lagos")
    val newManBirthday = Birthday(4, 4, 1990)

    val newMan = Person("john philips", 21, newManBirthday, newManAddress)
    var woman = newMan.copy()
    woman.name = "mary jane"

    var gson = Gson()

    var people = arrayOf(newMan, woman)

    // from pojo to Json
    var peopleInJsonFormat = gson.toJson(people)
    println(peopleInJsonFormat)

    var newPeople : Array<Person> = gson.fromJson(peopleInJsonFormat , Array<Person> :: class.java)
    println("\n  Back to pojo format")
    for(i in newPeople) println(i)
}*/

data class WatchMan(var movie :Movie)
data class Movie(var name: String, var watchDate: String,var provider: String ,var seriesNo: Int,var episodeNo: String)

fun main (){

    val gson = Gson()

    val movieList: Array<Movie> = gson.fromJson(FileReader("./src/main/resources/Prac.json"), Array<Movie>::class.java)
//   for (movie in movieList) println("\n $movie")

    val watchMan = WatchMan(movieList[2])
    println("watchMan movie name = " + watchMan.movie.name)
}

