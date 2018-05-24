package Views

import tornadofx.*
import Controller.Store

class BookView: View(){
    val store: Store by inject()
    override val root = vbox(){
        useMaxWidth = true
        scrollpane {
            prefHeight = 525.0
            text(store.display)
        }
    }
}