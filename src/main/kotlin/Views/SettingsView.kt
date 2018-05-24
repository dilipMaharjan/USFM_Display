package Views

import Controllers.BackGroundTheme
import javafx.geometry.Pos
import Controllers.SettingsController
import javafx.scene.control.ToggleGroup
import tornadofx.*

class SettingsView: View("Settings"){
    val settings: SettingsController by inject()
    private val toggleGroup = ToggleGroup()

    override val root = vbox(){
        alignment = Pos.BOTTOM_CENTER
        setPrefSize(300.0, 200.0)
        hbox(){
            alignment = Pos.BASELINE_LEFT
            vbox {
                paddingTop = 10.0
                paddingLeft = 30.0
                paddingBottom = 90.0
                label("Theme")
                radiobutton("Light", toggleGroup){
                    isSelected = settings.themeIsLight.value
//                    isSelected = bind{settings.themeIsLight.value}
                    action {
                        settings.toggleTheme()
                    }
                }
                radiobutton("Dark", toggleGroup) {
                    isSelected = settings.themeIsDark.value
                    action {
                        settings.toggleTheme()
                    }
                }
            }
        }
        hbox {
            alignment = Pos.BOTTOM_RIGHT
            paddingRight = 15.0
            paddingBottom = 10.0
            button("OK"){
                setPrefSize(70.0, 30.0)
                action{
                    find(SettingsView::class).close()
                }
            }
        }
    }
}