package Views

import tornadofx.*
import Controller.Store

class TextView: View(){
    val store: Store by inject()
    override val root = borderpane{
        setPrefSize(800.0, 600.0)
        top(ToolBar::class)
        center(BookView::class)
        bottom(FooterView::class)
    }
    init{
        title = store.file.name.removeRange(
                store.file.name.indexOf(".")..store.file.name.indexOf(store.file.name.last()))
    }
}
