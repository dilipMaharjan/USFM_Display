package Views

import javafx.geometry.Pos
import Controllers.SettingsController
import javafx.scene.control.ToggleGroup
import tornadofx.*

class SettingsView: View("Settings"){
    val settings: SettingsController by inject()
    private val toggleGroup = ToggleGroup()

    override val root = vbox(){
        setPrefSize(300.0, 200.0)
        hbox(){
            alignment = Pos.BASELINE_LEFT
            hboxConstraints {
                marginLeft = 10.0
                marginTop = 10.0
            }
            vbox {
                label("Theme")
                radiobutton("Light", toggleGroup) {

                    action {
                        settings.toggleTheme()
                    }
                }
                radiobutton("Dark", toggleGroup) {
                    action {
                        settings.toggleTheme()
                    }
                }
            }

        }
    }
}