package edu.itsco.examplecomposebd.ui.screens

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.itsco.examplecomposebd.data.persistence.Product
import edu.itsco.examplecomposebd.data.persistence.ProductRoomDatabase
import edu.itsco.examplecomposebd.data.repositories.ProductRepository

class ProductViewModel(application: Application): ViewModel() {

    val allProducts: LiveData<List<Product>>
    private val repository: ProductRepository

    init{
        val productDb = ProductRoomDatabase.getInstance(application)
        val productDao = productDb.productDao()

        repository = ProductRepository(productDao)
        allProducts = repository.allProducts
    }

    fun insertProduct(product: Product){
        repository.insertProduct(product)
    }

    fun deleteProduct(product: Product){
        repository.deleteProduct(product)
    }
}

class ProductViewModelFactory(val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(application) as T
    }
}