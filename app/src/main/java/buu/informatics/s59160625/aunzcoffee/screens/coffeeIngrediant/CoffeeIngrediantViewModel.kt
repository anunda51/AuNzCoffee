package buu.informatics.s59160625.aunzcoffee.screens.coffeeIngrediant

import androidx.lifecycle.ViewModel
import buu.informatics.s59160625.aunzcoffee.data.MyIngrediant

class CoffeeIngrediantViewModel: ViewModel() {
    var ingrediantName = listOf(
        MyIngrediant("ผงกาแฟ"),
        MyIngrediant("นม")
    )
}