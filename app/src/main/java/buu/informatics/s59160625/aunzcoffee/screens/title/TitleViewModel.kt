package buu.informatics.s59160625.aunzcoffee.screens.title

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import buu.informatics.s59160625.aunzcoffee.database.Coffee
import buu.informatics.s59160625.aunzcoffee.database.CoffeeDatabaseDao
import kotlinx.coroutines.*

class TitleViewModel(coffeeDatabase: CoffeeDatabaseDao,
                     application: Application
    ) : AndroidViewModel(application) {
    var checktBtn = 0
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
            Log.i("data",data.toString())
            data

        }
    }

    private suspend fun insertToDatabase(coffee: Coffee){
        withContext(Dispatchers.IO) {
            database.insert(coffee)
        }
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }

    fun onStart() {
        uiScope.launch {
            var newCoffee = Coffee()
            newCoffee.coffeeName = "capuccino"

            insertToDatabase(newCoffee)

            coffee.value = getCoffeeFromDatabase()
        }
    }

    fun onClear() {
        uiScope.launch {
            clear()
            coffee.value = null
        }
    }
}