package edu.itsco.examplecomposebd.data.repositories

import androidx.lifecycle.LiveData
import edu.itsco.examplecomposebd.data.persistence.Product
import edu.itsco.examplecomposebd.data.persistence.ProductDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductRepository(private val productDao: ProductDao) {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val allProducts: LiveData<List<Product>> = productDao.getAllProducts()

    fun insertProduct(product: Product){
        coroutineScope.launch(Dispatchers.IO) {
            productDao.insertProduct(product)
        }
    }

    fun deleteProduct(product: Product){
        coroutineScope.launch(Dispatchers.IO){
            productDao.deleteProduct(product)
        }
    }
}