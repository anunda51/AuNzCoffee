package buu.informatics.s59160625.aunzcoffee.screens.coffeeIngrediant

import androidx.lifecycle.ViewModel
import buu.informatics.s59160625.aunzcoffee.data.MyBrewing
import buu.informatics.s59160625.aunzcoffee.data.MyIngrediant

class CoffeeIngrediantViewModel: ViewModel() {
    var ingrediantName = listOf<MyIngrediant>()
    var brewing = listOf<MyBrewing>()

    fun checkCoffeeToGetIngrediant(item: String){
        if(item === "คาปูชิโน่"){
            ingrediantName = listOf(
                MyIngrediant("เมล็ดกาแฟชนิดคั่วระดับเข้ม 8 กรัม (สำหรับ 1 ช็อต)"),
                MyIngrediant("น้ำ 2 ออนซ์"),
                MyIngrediant("นมสด"),
                MyIngrediant("น้ำตาล"),
                MyIngrediant("ผงอบเชย (โรยเพิ่มความหอมและสวยงาม)")
            )
            brewing = listOf(
                MyBrewing("เริ่มด้วยการทำฟองนม นำนมสดมาเป่าด้วยเครื่องชงกาแฟ ซึ่งจะมีท่อสำหรับเป่าลมร้อน"),
                MyBrewing("ชงกาแฟ 1 ช็อต ให้ได้ระดับน้ำ 1/3 ถ้วยกาแฟ"),
                MyBrewing("เทนมร้อน ลงไปอีก1/3 ถ้วยกาแฟ"),
                MyBrewing("ตักฟองนม เติมลงในถ้วยกาแฟให้พูนๆสวยงาม (ไม่ต้องล้นนะคะ)"),
                MyBrewing("โรยบนฟองนมด้วยผงอบเชยเล็กน้อย เป็นอันสำเร็จค่ะ")
            )
        }
    }
}