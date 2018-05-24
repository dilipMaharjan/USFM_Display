package Controllers

import app.USFMApp
import javafx.beans.property.SimpleBooleanProperty
import tornadofx.*

class SettingsController: Controller(){
    val themeIsLight = SimpleBooleanProperty(true)
    val themeIsDark = SimpleBooleanProperty(false)

    fun toggleTheme(){
        themeIsLight.value = !(themeIsLight.value)
        themeIsDark.value = !(themeIsDark.value)

        if(themeIsDark.value){

        }
    }
}
enum class BackGroundTheme{light, dark}
