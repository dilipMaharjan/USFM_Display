package Models

import StyleSheets.DarkTheme
import StyleSheets.LightTheme
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleObjectProperty
import tornadofx.*
import kotlin.reflect.KClass

class Settings(){
    val themes = SimpleListProperty<KClass<out Stylesheet>>(listOf(LightTheme::class, DarkTheme::class).observable())
    val activeThemeProperty = SimpleObjectProperty<KClass<out Stylesheet>>()
    private var activeTheme by activeThemeProperty
    init{
        activeThemeProperty.addListener{_, oldTheme, newTheme ->
            oldTheme?.let { removeStylesheet(it) }
            newTheme?.let { importStylesheet(it) }
            activeTheme = newTheme
        }
        activeTheme = themes.first()
    }
}
