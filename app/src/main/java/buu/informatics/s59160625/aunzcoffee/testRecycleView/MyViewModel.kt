package buu.informatics.s59160625.aunzcoffee.testRecycleView

import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    val items = listOf(
        MyData("AAA"),
        MyData("AAA"),
        MyData("AAA")
    )
}