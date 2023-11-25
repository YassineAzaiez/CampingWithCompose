sealed class Screens(open val route: String) {
   object Splash : Screens("splash")

   object Auth : Screens("authentication")
   object Home : Screens("homeScreen")
   object Fitness : Screens("fitness")
   object BackPack : Screens("backPack")
   object TeamMates : Screens("teamMates")
   object Default : Screens("")
}
sealed class Launch(override val route: String): Screens(route){
   object Splash : Launch("splashScreen")
   object OnBoarding : Launch("onBoardingScreen")
}

sealed class Authentication(override val route: String): Screens(route){
   object Login : Authentication("login")
   object ForgetPassword : Authentication("forgetPassword")

}