package Views

import javafx.geometry.Pos
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*
import Controller.Store
import javafx.stage.FileChooser

class WelcomeView: View("Welcome"){
    val store: Store by inject()
    override val root = vbox(5){
        setPrefSize(300.0, 100.0)
        hbox{
            alignment = Pos.BASELINE_RIGHT
            label("Select Book"){
                font = Font.font("verdanna", FontWeight.BOLD, 13.0)
                hboxConstraints {
                    marginRight = 40.0
                    marginTop = 15.0
                }
            }
        }
        hbox {
            alignment = Pos.CENTER
            button("Load USFM"){
                prefWidth = 110.0
                alignment = Pos.CENTER
                isDefaultButton = true
                paddingAll = 10
                hboxConstraints {
                    marginRight = 25.0
                }
                action {
                    store.loadFile(filters = arrayOf(FileChooser.ExtensionFilter("USFM File", "*.usfm")))
                    find(WelcomeView::class).replaceWith(TextView::class, sizeToScene = true, centerOnScreen = true)
                }
            }
            combobox<String> {
                setPrefSize(110.0, 25.0)
                isDisable = true
                paddingAll = 5
                hboxConstraints {
                    marginLeft = 25.0
                }
            }
        }
    }
}