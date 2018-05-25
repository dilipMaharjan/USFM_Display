package app

import Views.WelcomeView
import tornadofx.*
import javafx.stage.Stage

class USFMApp: App(WelcomeView::class, DarkThemeStyleSheet::class){
    init{
        reloadStylesheetsOnFocus()
    }
}
