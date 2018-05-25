package Views

import Controllers.SettingsController
import tornadofx.*

class SettingsView: View("Settings"){
    private val settings: SettingsController by inject()

    override val root = form{
        fieldset("Theme") {
            field{
                vbox {
                    togglegroup{
                        settings.settings.themes.forEach{theme ->
                            radiobutton(theme.simpleName, getToggleGroup(), theme){
                                isSelected = (theme.simpleName == "LightTheme")
                                action {
                                    settings.changeTheme()
                                }
                            }
                        }
                        bind(settings.settings.activeThemeProperty)
                    }
                }
                buttonbar {
                    button("OK").action(this@SettingsView::close)
                }
            }
        }
    }
}
