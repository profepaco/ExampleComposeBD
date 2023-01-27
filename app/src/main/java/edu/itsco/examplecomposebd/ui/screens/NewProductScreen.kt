package edu.itsco.examplecomposebd.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import edu.itsco.examplecomposebd.data.persistence.Product
import edu.itsco.examplecomposebd.navigation.Screen

@Composable
fun NewProductScreen(viewModel: ProductViewModel, navController: NavHostController){
    var productName by remember { mutableStateOf("") }
    var productQuantity by remember { mutableStateOf("") }

    val onProductNameChange = { text: String ->
        productName = text
    }

    val onProductQuantityChange = { text: String ->
        productQuantity = text
    }

    Column() {
        CustomOutline(
            title = "Nombre",
            textState = productName,
            onTextChange = onProductNameChange,
            keyboardType = KeyboardType.Text
        )
        CustomOutline(
            title = "Cantidad",
            textState = productQuantity,
            onTextChange = onProductQuantityChange,
            keyboardType = KeyboardType.Number
        )
        Button(
            onClick = {
                viewModel.insertProduct(
                    Product(
                        id = 0,
                        productName = productName,
                        quantity = productQuantity.toInt()
                    )
                )
                navController.navigate(
                    route = Screen.ListaProductos.route
                )
            }
        ) {
            Text("Guardar producto")
        }
    }
}

@Composable
fun CustomOutline(
    title: String,
    textState: String,
    onTextChange: (String) -> Unit,
    keyboardType: KeyboardType
){
    OutlinedTextField(
        value = textState,
        onValueChange = { onTextChange(it) },
        singleLine = true,
        label = { Text(title) },
        modifier = Modifier.padding(4.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}
