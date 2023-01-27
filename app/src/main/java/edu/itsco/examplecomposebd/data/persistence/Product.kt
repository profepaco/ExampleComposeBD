package edu.itsco.examplecomposebd.data.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("products")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo("product_name") val productName: String,
    val quantity: Int,
)
