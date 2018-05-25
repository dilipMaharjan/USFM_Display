package Models

import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class Book(title: String){
    val titleProperty = SimpleStringProperty("$title\n")
    var title by titleProperty
    val chaptersListProperty = SimpleListProperty<Chapter>(mutableListOf<Chapter>().observable())
    var chapters by chaptersListProperty
    init {
        titleProperty.value
    }
}
//class BookModel(property: ObjectProperty<Book>): ItemViewModel<Book>(itemProperty = property){
//    val title = bind(autocommit = true){
//        item?.titleProperty
//    }
//    val chapters = bind(autocommit = true){
//        item?.chaptersListProperty
//    }
//}