package Views

import javafx.geometry.Pos
import Controllers.SettingsController
import Models.BackGroundThemeState.Dark
import Models.BackGroundThemeState.Light
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
                    isSelected = true
                    action {
                      settings.changeTheme(Light)
                    }
                }
                radiobutton("Dark", toggleGroup) {
                    action {
                        settings.changeTheme(Dark)
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