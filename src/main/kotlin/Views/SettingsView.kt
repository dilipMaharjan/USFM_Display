package Views

import javafx.geometry.Pos
import tornadofx.*

class SettingsView: View("Settings"){
    override val root = vbox(){
        setPrefSize(300.0, 200.0)
        hbox(){
            alignment = Pos.BASELINE_LEFT
            hboxConstraints {
                marginLeft = 10.0
                marginTop = 10.0
            }
            togglegroup(){
                vbox {
                    label("Theme")
                    radiobutton("Light") {

                    }
                    radiobutton("Dark") {

                    }
                }
            }
        }
    }
}