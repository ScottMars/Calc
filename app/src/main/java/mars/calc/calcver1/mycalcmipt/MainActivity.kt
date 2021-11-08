package mars.calc.calcver1.mycalcmipt


import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import mars.calc.calcver1.mycalcmipt.feature_calc.presentation.calculator.CalculatorScreen
import mars.calc.calcver1.mycalcmipt.feature_calc.presentation.theme.CalcAppTheme
import mars.calc.calcver1.mycalcmipt.feature_calc.presentation.util.Screen

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalcAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CalcScreen.route
                    )
                    {
                        composable(route = Screen.CalcScreen.route) {
                            CalculatorScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

