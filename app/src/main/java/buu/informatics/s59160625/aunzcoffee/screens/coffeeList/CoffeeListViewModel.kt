package buu.informatics.s59160625.aunzcoffee.screens.coffeeList

import android.util.Log
import androidx.lifecycle.ViewModel

class CoffeeListViewModel : ViewModel(){
    var num = 0
    var name = ""
    var coffeeList = arrayOf("คาปูชิโน่",
        "ลาเต้",
        "มอคค่า",
        "เอสเปรสโซ่",
        "อเมริกาโน่")
//    private val coffee = coffeeDatabase.getAllCoffees()

//    val coffeeString = Transformations.map(coffee) { coffee ->
//        formatCoffee(coffee, application.resources)
//    }
    override fun onCleared() {
        super.onCleared()
        Log.i("CoffeeListViewModel", "CoffeeListViewModel destroyed!")
    }

    fun checkOnClick(){
        if (num==1){ name = coffeeList[0] }
        if (num==2){ name = coffeeList[1] }
        if (num==3){ name = coffeeList[2] }
        if (num==4){ name = coffeeList[3] }
        if (num==5){ name = coffeeList[4] }
    }
}