package buu.informatics.s59160625.aunzcoffee.screens.title

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import buu.informatics.s59160625.aunzcoffee.database.CoffeeDatabaseDao

class TitleViewModel(val coffeeDatabase: CoffeeDatabaseDao,
                     application: Application
    ) : AndroidViewModel(application) {
    var checktBtn = 0
}