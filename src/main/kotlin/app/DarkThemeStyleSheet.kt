package app

import javafx.scene.paint.Color
import tornadofx.*

class DarkThemeStyleSheet: Stylesheet(){
    init {
        button{
            backgroundColor += Color.DARKGRAY
            textFill = Color.BLUE
            borderColor += box(Color.BLUE)
        }
    }
}
