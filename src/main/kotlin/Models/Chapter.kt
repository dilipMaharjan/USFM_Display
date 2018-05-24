package Models

import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class Chapter(title: String){
    val titleProperty = SimpleStringProperty("Chapter $title\n")
    var title by titleProperty
    //    val verseListProperty = SimpleListProperty<Verse>()
    //    var verses by verseListProperty
    var verses = mutableListOf<Verse>()
}

//class ChapterModel(property: ObjectProperty<Chapter>): ItemViewModel<Chapter>(itemProperty = property){
//    val title = bind(autocommit = true){
//        item?.titleProperty
//    }
//}