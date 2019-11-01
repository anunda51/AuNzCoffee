package buu.informatics.s59160625.aunzcoffee.screens.title

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import buu.informatics.s59160625.aunzcoffee.database.CoffeeDatabaseDao

class TitleViewModelFactory(
    private val dataSource: CoffeeDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TitleViewModel::class.java)) {
            return TitleViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}