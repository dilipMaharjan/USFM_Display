package Views

import javafx.stage.FileChooser
import tornadofx.*
import Controller.Store

class ToolBar: View(){
    val store: Store by inject()
    override val root = menubar{
        menu("File") {
            item("Save"){}
            item("Settings"){
                action{
                    find(SettingsView::class).openModal()
                }
            }
        }
        menu("Edit"){

        }
        menu("View"){
            item("Home Screen"){
                action{
                    find(TextView::class).replaceWith(WelcomeView::class, sizeToScene = true, centerOnScreen = true)
                }
            }
        }
        menu("Help"){

        }
    }
}