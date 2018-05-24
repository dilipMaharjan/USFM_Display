package app

import Views.WelcomeView
import tornadofx.*
import javafx.stage.Stage

class USFMApp: App(){
    override val primaryView = WelcomeView::class

    override fun start(stage: Stage) {
//        importStylesheet("/Style.css")
        stage.isResizable = false
        super.start(stage)
    }
}
