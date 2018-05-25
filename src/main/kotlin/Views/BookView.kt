package Views

import Controller.Store
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*

class BookView : View() {

    val store: Store by inject()

    var chapterNum = SimpleIntegerProperty(1)
    var chapterNumChanged = objectBinding(chapterNum) { chapterNum }

    var chapterTitle = SimpleStringProperty()
    var chapterTitleChanged = objectBinding(chapterTitle) { chapterTitle }

    var verses = SimpleStringProperty()
    var versesChanged = objectBinding(verses) { verses }

    init {
        val (title, verse) = getChapterText(chapterNumChanged.value!!.value)
        chapterTitle.value = title
        verses.value = verse
    }

    override val root = vbox {
        useMaxWidth = true
        prefHeight = 525.0
        prefWidth = 525.0
        scrollpane {
            vbox {
                text(store.book.title) {
                    font = Font.font("sans-serif", FontWeight.EXTRA_BOLD, 18.0)
                    fill = Color.RED
                    stroke = Color.BLACK
                    strokeWidth = 0.75
                }

                text(stringBinding(chapterTitleChanged) { chapterTitleChanged.value!!.value }) {
                    font = Font.font("sans-serif", FontWeight.EXTRA_BOLD, 18.0)
                    stroke = Color.RED
                    fill = Color.BLACK
                    strokeWidth = 0.75
                }
                text(stringBinding(versesChanged) { versesChanged.value!!.value })

            }
        }
        hbox {
            button("<<<Prev").setOnAction {
                selectChapter("prev")
                val (title, verse) = getChapterText(chapterNumChanged.value!!.value)
                chapterTitle.value = title
                verses.value = verse

            }
            button(stringBinding(chapterNumChanged) { chapterNumChanged.value!!.value.toString() })
            button(">>>Next").setOnAction {
                selectChapter("nxt")
                val (title, verse) = getChapterText(chapterNumChanged.value!!.value)
                chapterTitle.value = title
                verses.value = verse
            }
        }
    }

    private fun selectChapter(string: String): Int {
        if (string == "prev") {
            if (chapterNum.value > 1) chapterNum.value -= 1 else chapterNum.value = 1
        } else if (string == "nxt") {
            if (chapterNum.value < store.book.chapters.size)
                chapterNum.value += 1
            else
                chapterNum.value = 1
        }
        return chapterNum.value
    }

    private fun getChapterText(chapterNum: Int): Pair<String, String> {
        var chapterTitle: String by singleAssign()
        val sb = StringBuilder()
        for (chap in store.book.chapters) {
            if (store.getChapterNumber(chap.title) == chapterNum) {
                chapterTitle = chap.title
                for (v in chap.verses) {
                    sb.append(v.text)
                }
            }
            continue
        }
        return Pair(chapterTitle, sb.toString())
    }
}
