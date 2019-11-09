package buu.informatics.s59160625.aunzcoffee.screens.myFavorite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import buu.informatics.s59160625.aunzcoffee.database.Coffee
import buu.informatics.s59160625.aunzcoffee.database.CoffeeDatabaseDao
import kotlinx.coroutines.*

class MyFavoriteViewModel(coffeeDatabase: CoffeeDatabaseDao,
                          application: Application
    ) : AndroidViewModel(application) {

    val database = coffeeDatabase
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private var coffee = MutableLiveData<Coffee?>()

    val allCoffee = database.getAllCoffees()

    init {
        initializeTonight()
    }

    private fun initializeTonight() {
        uiScope.launch {
            coffee.value = getCoffeeFromDatabase()
        }
    }

    private suspend fun getCoffeeFromDatabase(): Coffee? {
        return withContext(Dispatchers.IO) {
            var data = database.getLastCoffee()
            data

        }
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }

    fun onClear() {
        uiScope.launch {
            clear()
            coffee.value = null
        }
    }
}