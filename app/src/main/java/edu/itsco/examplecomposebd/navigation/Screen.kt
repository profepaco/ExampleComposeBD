package edu.itsco.examplecomposebd.navigation

sealed class Screen(val route: String) {
    object ListaProductos: Screen(route = "lista_usuarios_screen")
    object NuevoProducto: Screen(route = "nuevo_producto_screen")
}