package StyleSheets
import javafx.scene.paint.Color
import tornadofx.*

class DarkTheme: Stylesheet(){
    init{
        root{
            backgroundColor += Color.DARKGRAY
        }
    }
}