package Controllers

import Models.BackGroundThemeState
import tornadofx.*
import Models.Settings
import Models.BackGroundThemeState.Dark
import Models.BackGroundThemeState.Light

class SettingsController: Controller(){
    private var settings = Settings()

    fun changeTheme(state: BackGroundThemeState){
        when(state){
            Light -> settings.BackGroundTheme = Light
            Dark  -> settings.BackGroundTheme = Dark
        }
//        println("BackGroundTheme is set to ${settings.BackGroundTheme}")
        when(settings.BackGroundTheme){
//            Light -> break
//            Dark  -> importStylesheet(app.DarkThemeStyleSheet)
        }
        reloadStylesheetsOnFocus()
    }
}
