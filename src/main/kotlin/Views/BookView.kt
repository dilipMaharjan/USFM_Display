package Views

import Controller.Store
import tornadofx.*

class BookView : View() {
    val store: Store by inject()
    var chapterNum = 2
    override val root = vbox {
        useMaxWidth = true
        prefHeight = 525.0
        scrollpane {
            vbox {
                text(store.book.title)
                for (chap in store.book.chapters) {
                    if (store.getChapterNumber(chap.title) == chapterNum) {
                        text(chap.title)
                        for (v in chap.verses) {
                            text(v.text)
                        }
                        continue
                    }
                }
            }
        }
        hbox {
            button("<<<Prev") {
                action {
                    if (chapterNum > 1) chapterNum -= 1 else chapterNum = 1
                }

            }
            button(chapterNum.toString()) {
            }
            button(">>>Next") {
                action {
                    if (chapterNum < store.book.chapters.size)
                        chapterNum += 1
                    else
                        chapterNum = 1
                }
            }

        }
    }
}
