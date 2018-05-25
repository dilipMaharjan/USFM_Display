package Views

import Controllers.SettingsController
import javafx.geometry.Pos
import tornadofx.*

class SettingsView: View("Settings"){
    private val settings: SettingsController by inject()

    override val root = vbox{
        alignment = Pos.BOTTOM_CENTER
        setPrefSize(300.0, 100.0)
        hbox {
            alignment = Pos.BASELINE_LEFT
            vbox(10) {
                paddingTop = 20.0
                paddingLeft = 30.0
                paddingBottom = 90.0
                label("Theme")
                togglegroup {
                    //create a radio button for each of the themes
                    settings.settings.themes.forEach { theme ->
                        radiobutton(theme.simpleName, getToggleGroup(), theme) {
                            //the light theme will be
                            isSelected = (title == "LightTheme")
                            action {
                                settings.changeTheme()
                            }
                        }
                    }
                    bind(settings.settings.activeThemeProperty)
                }
            }
        }
        hbox{
            alignment = Pos.BOTTOM_RIGHT
            paddingRight = 15.0
            paddingBottom = 10.0
            buttonbar {
                button("OK"){
                    action{
                        find(SettingsView::class).close()
                    }
                    setPrefSize(70.0, 30.0)
                }
            }
        }
    }
}
