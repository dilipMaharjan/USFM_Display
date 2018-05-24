package Models

import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

//data class Models.Verse(val number: Int, val text: String)
class Verse(text: String){
    val textProperty = SimpleStringProperty("$text\n")
    var text by textProperty
}

//class VerseModel(property: ObjectProperty<Verse>): ItemViewModel<Verse>(itemProperty = property){
//    val text = bind(autocommit = true){
//        item?.textProperty
//    }
//}