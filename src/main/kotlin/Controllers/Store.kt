package Controller

import Models.Book
import Models.Chapter
import Models.Verse
import Views.TextView
import javafx.beans.property.SimpleStringProperty
import javafx.stage.FileChooser
import tornadofx.*
import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files

class Store : Controller() {
    lateinit var file: File
    val titleProperty = SimpleStringProperty("")
    var book = Book(titleProperty.value)
    val display = SimpleStringProperty("")

    fun addVerse(chapter: Chapter, text: String) {
        var newVerse = Verse(text.removePrefix("\\v").trim())
        chapter.verses.add(newVerse)
        display.value += newVerse.text
    }

    fun addChapter(book: Book, text: String) {
        var newChapter = Chapter(text.removePrefix("\\c").trim())
        book.chapters.add(newChapter)
        display.value += newChapter.title
    }

    fun changeTitle(text: String) {
        this.book.titleProperty.value = text.removePrefix("\\h").trim() + "\n"
        display.value += book.title
    }

    //Remove footer tags from USFM file contents
    fun String.formatText(): String {
        if (this.contains("\\f"))
            return this.removeRange(this.indexOf("\\f")..this.length - 1)
        return this
    }

    fun parseText(text: String) {
        val fileContents = text.split("\n")
        loop@ for (line in fileContents) {
            when {
                line.startsWith("\\h") -> changeTitle(line)
                line.startsWith("\\c") -> addChapter(book, line)
                line.startsWith("\\v") -> addVerse(book.chapters.last(), line.formatText())
                else -> continue@loop
            }
        }
    }

    fun loadFile(
        parser: (File) -> String = { Files.readAllBytes(it.toPath()).toString(StandardCharsets.UTF_8) },
        filters: Array<FileChooser.ExtensionFilter>
    ) {
        var fileContents = SimpleStringProperty()
        chooseFile("Select USFM File", filters, FileChooserMode.Single).singleOrNull()?.let {
            fileContents.value = parser.invoke(it)
            file = it
        }
        if (fileContents.value != null)
            this.parseText(fileContents.value)
    }
    enum class BackGroundTheme { light, dark }

    fun getChapterNumber(string: String): Int {
        return string.split(" ")[1].trim().toInt()
    }
}


