package edu.itsco.examplecomposebd.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import edu.itsco.examplecomposebd.data.persistence.Product
import edu.itsco.examplecomposebd.navigation.Screen

@Composable
fun ProductScreen(viewModel: ProductViewModel, navController: NavHostController){
    val allProducts:List<Product> by viewModel.allProducts.observeAsState(listOf())

    Scaffold(
        topBar =  {
            TopAppBar(
                title = { Text("Lista de Productos") }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("ADD") },
                onClick = {
                    navController.navigate(
                        route = Screen.NuevoProducto.route
                    )
                },
                icon = {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "icono")
                }
            )
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ){
            items(allProducts){ product ->
                ProductCard(product = product)
            }
        }
    }


}

@Composable
fun ProductCard(product: Product){
    Card() {
        Row(){
            Text(text = product.productName)
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.ChevronRight,
                    contentDescription = "icono"
                )
            }
        }
    }
}
