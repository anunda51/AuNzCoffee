package buu.informatics.s59160625.aunzcoffee.screens.coffeeList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import buu.informatics.s59160625.aunzcoffee.data.MyCoffee
import buu.informatics.s59160625.aunzcoffee.data.MyTea

class CoffeeListViewModel : ViewModel(){

    private val _coffee = MutableLiveData<List<MyCoffee>>()
    val coffee: LiveData<List<MyCoffee>>
        get() = _coffee

    private val _tea = MutableLiveData<List<MyTea>>()
    val tea: LiveData<List<MyTea>>
        get() = _tea

    private fun setData(){
        _coffee.value = listOf(
            MyCoffee("คาปูชิโน่"),
            MyCoffee("ลาเต้"),
            MyCoffee("มอคค่า"),
            MyCoffee("เอสเปรสโซ่"),
            MyCoffee("อเมริกาโน่")
        )
        _tea.value = listOf(MyTea("ชานม"),
            MyTea("ชาเขียว"),
            MyTea("ชามะลิ"),
            MyTea("ชาดำ"),
            MyTea("ชาไทย")
        )
    }

    init {
        setData()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("CoffeeListViewModel", "CoffeeListViewModel destroyed!")
    }
}