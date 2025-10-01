package com.example.viewmodels.data
import androidx.lifecycle.ViewModel
import com.example.viewmodels.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class Person(val name: String, val desc: String, val image: Int)

object DataSource {
    val people = listOf(
        Person("Ken Thompson", "Ken Thompson designed and implemented the Unix operating system while working at Bell Labs. He is also the creator of the B programming language as well as UTF-8 encoding – which made it possible for computers to display and exchange data in multiple languages. Later in his career, Thompson also co-invented the Go programming language.", R.drawable.ken_thompson),
        Person("Steve Bourne", "teve Bourne created the Bourne shell (sh) and other Unix tools as a researcher at Bell Labs. The Bourne shell became Unix’s default shell in Version 7 Unix (replacing the original shell written by Ken Thompson) and introduced the concept of “shell scripting” by adding programming capabilities to the command-line interpreter.", R.drawable.steve_bourne),
        Person("Linus Torvalds", "Linus Torvalds invented the Linux operating system which is used to run the vast majority of computer servers connected to the Internet. Torvalds also invented the Git version control system which he uses to manage the source code changes made to Linux by thousands of open source developers.", R.drawable.linus_torvalds),
        Person("GUIDO VAN ROSSUM", "Guido van Rossum is the creator of the Python programming language. Van Rossum holds the title of “Benevolent Dictator for Life” within the Python community which uses a collaborative open source development model to create new versions of the programming language.", R.drawable.guido_rossum),
        Person("BRENDAN EICH", "Brendan Eich is a computer scientist and the creator of the JavaScript programming language. In addition, Eich co-founded the Mozilla project which manages the open source development of the Firefox web browser. He is also the CEO and co-founder of Brave Software, a start-up that is building an open source, privacy-focused browser, as well as a blockchain-based digital advertising platform.", R.drawable.brendan_eich),
        Person("JAMES GOSLING", "James Gosling is a Canadian computer scientist best known for inventing the Java programming language and virtual machine. Initially named “Oak” after a tree outside his office at Sun Microsystems, Java today has multiple open source distributions including OpenJDK and Amazon Corretto. In addition to his work on Java, Gosling also developed software for the Unix operating system including the shar utility which was used to bundle software programs and files together into a self extracting archive. Widely recognized for his contributions to the field of computer science, Gosling was named an Officer of the Order of Canada — the country’s highest civilian honor.", R.drawable.james_gosling)
    )
}

data class PersonUi( val indexPerson: Int = 0, val person: Person = DataSource.people[0])

class PersonViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(value = PersonUi())
    val uiState = _uiState.asStateFlow()

    fun previousPerson() {
        val novo = (_uiState.value.indexPerson - 1).mod(DataSource.people.size)

        _uiState.update {
            it.copy(
                indexPerson = novo,
                person = DataSource.people[novo]
            )
        }
    }

    fun nextPerson() {
        val novo = (_uiState.value.indexPerson + 1).mod(DataSource.people.size)

        _uiState.update {
            it.copy(
                indexPerson = novo,
                person = DataSource.people[novo]
            )
        }
    }

}