package com.example.campingwithcompose.navigation

sealed interface Screens {
   val route: String

   object Splash : Screens {
      override val route: String
         get() = "splashScreen"
   }

   object OnBoarding : Screens {
      override val route: String
         get() = "onBoarding"

   }

   object Login : Screens {
      var launchInclusive: Boolean = true
      var launchSingleTop: Boolean = true
      override val route: String
         get() = "login"

   }

   object Home : Screens {
      override val route: String
         get() = "homeScreen"
   }

   object Fitness : Screens {
      override val route: String
         get() = "fitness"

   }

   object BackPack : Screens {
      override val route: String
         get() = "fitness"

   }

   object TeamMates : Screens {
      override val route: String
         get() = "teamMates"
   }

   object Default : Screens {
      override val route: String
         get() = ""
   }
}
