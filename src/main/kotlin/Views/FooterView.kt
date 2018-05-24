package Views

import javafx.geometry.Pos
import javafx.scene.layout.Border
import tornadofx.*

class FooterView: View(){
    override val root = hbox(){
        alignment = Pos.BASELINE_RIGHT
        button("Save"){
            setPrefSize(70.0, 30.0)
            isDisable = true
            hboxConstraints {
                marginRight  = 15.0
                marginBottom = 10.0
            }
        }
    }
}