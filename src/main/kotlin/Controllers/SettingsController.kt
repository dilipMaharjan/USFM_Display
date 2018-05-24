package Controllers

import javafx.beans.property.SimpleBooleanProperty
import tornadofx.*

class SettingsController: Controller(){
    val themeIsLight = SimpleBooleanProperty(true)
    val themeIsDark = SimpleBooleanProperty(false)

    fun toggleTheme(){
        themeIsLight.value = !(themeIsLight.value)
        themeIsDark.value = !(themeIsDark.value)
        println("themeIsLight = ${themeIsLight.value}")
        println("themeIsDark= ${themeIsDark.value}")
    }
}
enum class BackGroundTheme{light, dark}
