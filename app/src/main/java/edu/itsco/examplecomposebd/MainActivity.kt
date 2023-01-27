package edu.itsco.examplecomposebd

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import edu.itsco.examplecomposebd.navigation.SetupNavGraph
import edu.itsco.examplecomposebd.ui.screens.NewProductScreen
import edu.itsco.examplecomposebd.ui.screens.ProductScreen
import edu.itsco.examplecomposebd.ui.screens.ProductViewModel
import edu.itsco.examplecomposebd.ui.screens.ProductViewModelFactory
import edu.itsco.examplecomposebd.ui.theme.ExampleComposeBDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleComposeBDTheme {

                val owner = LocalViewModelStoreOwner.current
                val navController: NavHostController = rememberNavController()
                owner?.let {
                    val viewModel: ProductViewModel = viewModel(
                        it, "ProductViewModel",
                        ProductViewModelFactory(
                            LocalContext.current.applicationContext as Application
                        )
                    )
                    SetupNavGraph(viewModel = viewModel, navController =  navController)
                    //ProductScreen(viewModel = viewModel, navController = navController)
                    //NewProductScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExampleComposeBDTheme {
        Greeting("Android")
    }
}