package mars.calc.calcver1.mycalcmipt.feature_calc.presentation


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mars.calc.calcver1.mycalcmipt.feature_calc.presentation.theme.CalcAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalcAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "")
                    {
                        composable(route = "") {


                        }
                        composable(route = "") {


                        }
                    }
                }
            }
        }
    }
}

