package StyleSheets

import javafx.scene.paint.Color
import tornadofx.*

class LightTheme: Stylesheet(){
    init{
        root{
            backgroundColor += Color.WHITE
            button{
                borderRadius += box(5.px)
            }
        }
    }
}