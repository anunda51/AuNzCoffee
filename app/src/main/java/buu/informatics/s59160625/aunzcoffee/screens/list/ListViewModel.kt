package buu.informatics.s59160625.aunzcoffee.screens.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import buu.informatics.s59160625.aunzcoffee.data.MyCoffee

class ListViewModel : ViewModel(){

    private val _coffee = MutableLiveData<List<MyCoffee>>()
    val coffee: LiveData<List<MyCoffee>>
        get() = _coffee

    fun setData(num: Int){
        if (num == 1){
            _coffee.value = listOf(
                MyCoffee("คาปูชิโน่"),
                MyCoffee("ลาเต้"),
                MyCoffee("มอคค่า"),
                MyCoffee("เอสเพรสโซ่"),
                MyCoffee("อเมริกาโน่")
            )
        }else{
            _coffee.value = listOf(
                MyCoffee("ชานม"),
                MyCoffee("ชาเขียว"),
                MyCoffee("ชามะลิ"),
                MyCoffee("ชาดำ"),
                MyCoffee("ชามะนาว")
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ListViewModel", "ListViewModel destroyed!")
    }
}