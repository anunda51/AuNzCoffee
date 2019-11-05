package buu.informatics.s59160625.aunzcoffee.screens.coffeeList

import android.util.Log
import androidx.lifecycle.ViewModel
import buu.informatics.s59160625.aunzcoffee.data.MyCoffee
import buu.informatics.s59160625.aunzcoffee.data.MyTea

class CoffeeListViewModel : ViewModel(){

    var coffeeList = listOf(MyCoffee("คาปูชิโน่"),
        MyCoffee("ลาเต้"),
        MyCoffee("มอคค่า"),
        MyCoffee("เอสเปรสโซ่"),
        MyCoffee("อเมริกาโน่")
    )

    var teaList = listOf(MyTea("ชานม"),
        MyTea("ชาเขียว"),
        MyTea("ชามะลิ"),
        MyTea("ชาดำ"),
        MyTea("ชาไทย"))

    override fun onCleared() {
        super.onCleared()
        Log.i("CoffeeListViewModel", "CoffeeListViewModel destroyed!")
    }

}