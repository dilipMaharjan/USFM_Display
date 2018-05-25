package StyleSheets
import javafx.scene.paint.Color
import tornadofx.*

class DarkTheme: Stylesheet(){
    companion object {
        private val whiteColor = c("fff")
        private val darkColor = c("333")
        private val greyColor = c("666")
        private val hoverColor = c("999")
    }
    init{
        root{
            backgroundColor += darkColor
            button{
                backgroundColor += greyColor
                textFill = whiteColor
                borderColor += box(whiteColor)
                borderRadius += box(5.px)
                and(hover){
                    backgroundColor += hoverColor
                }
            }
//            text{
//                textFill = whiteColor
//                backgroundColor += darkColor
//            }
//            scrollPane{
//                backgroundColor += darkColor
//                text{
//                    textFill = whiteColor
//                    backgroundColor += darkColor
//                }
//            }
            menuBar{
                backgroundColor += greyColor
                textFill = whiteColor
                menu{
//                    listView{
//                        backgroundColor += greyColor
//                    }
                    and(hover){
                        backgroundColor += hoverColor
                    }
                    menuItem{
                        backgroundColor += greyColor
                        textFill = whiteColor
                        and(hover){
                            backgroundColor += hoverColor
                        }
                    }
                }
            }

            label{
                textFill = whiteColor
            }
            radioButton{
                textFill = whiteColor
            }
        }
    }
}
