package pl.ar97.androidstudiobasics

import androidx.lifecycle.ViewModel

private val data = listOf<User>(
    User(
        name = "Peperon",
        surname = "Frogowski",
        technology = "Frontend, Javascript, CSS",
        birthDate = "10-02-1999",
        city = "Warsaw",
        image = R.drawable.pepe1
    ),
    User(
        name = "Pepeusz",
        surname = "Frogsten",
        technology = "Backend, Go, Rust",
        birthDate = "02-02-2001",
        city = "Krakow",
        image = R.drawable.pepe2
    ),
    User(
        name = "Parseusz",
        surname = "Frogowsky",
        technology = "FullStack, Devops",
        birthDate = "05-06-1996",
        city = "Poznan",
        image = R.drawable.pepe3
    )
)

interface Server {
    fun loadDataFromDb(): List<User>
}

class MainViewModel:ViewModel(), Server {
    private var user: User? = null

    override fun loadDataFromDb(): List<User> {
        return data
    }

    fun setUser(user: User){
        this.user = user
    }
    fun getUser() = user
}