package app

import Controllers.SettingsController
import StyleSheets.LightTheme
import Views.WelcomeView
import tornadofx.*
import javafx.stage.Stage

class USFMApp: App(WelcomeView::class, LightTheme::class){
    val settingsController: SettingsController by inject()

    override fun start(stage: Stage){
        super.start(stage)
        stage.isResizable = false
    }
}
