package br.com.miguel.recipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.miguel.recipes.navigation.NavigationRoutes
import br.com.miguel.recipes.screens.HomeScreen
import br.com.miguel.recipes.screens.InitialScreen
import br.com.miguel.recipes.screens.LoginScreen
import br.com.miguel.recipes.screens.SignupScreen
import br.com.miguel.recipes.ui.theme.RecipesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipesTheme {
                NavigationRoutes()
            }
        }
    }
}
