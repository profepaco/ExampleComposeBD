package edu.itsco.examplecomposebd.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import edu.itsco.examplecomposebd.ui.screens.NewProductScreen
import edu.itsco.examplecomposebd.ui.screens.ProductScreen
import edu.itsco.examplecomposebd.ui.screens.ProductViewModel

@Composable
fun SetupNavGraph(
    viewModel: ViewModel,
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.ListaProductos.route
    ){
        composable(
            route = Screen.ListaProductos.route
        ){
            ProductScreen(
                viewModel = viewModel as ProductViewModel,
                navController = navController)
        }
        composable(
            route = Screen.NuevoProducto.route
        ){
            NewProductScreen(viewModel = viewModel as ProductViewModel, navController = navController )
        }
    }
}


