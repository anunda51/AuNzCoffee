package buu.informatics.s59160625.aunzcoffee.screens.coffeeIngrediant

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import buu.informatics.s59160625.aunzcoffee.data.MyBrewing
import buu.informatics.s59160625.aunzcoffee.data.MyIngrediant
import buu.informatics.s59160625.aunzcoffee.database.Coffee
import buu.informatics.s59160625.aunzcoffee.database.CoffeeDatabaseDao
import kotlinx.coroutines.*

class CoffeeIngrediantViewModel(coffeeDatabase: CoffeeDatabaseDao,
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

    private suspend fun insertToDatabase(coffee: Coffee){
        withContext(Dispatchers.IO) {
            database.insert(coffee)
        }
    }

    fun insert(item : String) {
        uiScope.launch {
            var newCoffee = Coffee()
            newCoffee.coffeeName = item

            insertToDatabase(newCoffee)

            coffee.value = getCoffeeFromDatabase()
        }
    }

    private val _ingredientName = MutableLiveData<List<MyIngrediant>>()
    val ingredientName: LiveData<List<MyIngrediant>>
        get() = _ingredientName

    private val _brewing = MutableLiveData<List<MyBrewing>>()
    val brewing: LiveData<List<MyBrewing>>
        get() = _brewing

    fun checkCoffeeToGetIngredient(item: String){
        Log.i("args",item)
        if(item == "คาปูชิโน่"){
            _ingredientName.value = listOf(
                MyIngrediant("เมล็ดกาแฟชนิดคั่วระดับเข้ม 8 กรัม (สำหรับ 1 ช็อต)"),
                MyIngrediant("น้ำ 2 ออนซ์"),
                MyIngrediant("นมสด"),
                MyIngrediant("น้ำตาล"),
                MyIngrediant("ผงอบเชย (โรยเพิ่มความหอมและสวยงาม)")
            )
            _brewing.value = listOf(
                MyBrewing("เริ่มด้วยการทำฟองนม นำนมสดมาเป่าด้วยเครื่องชงกาแฟ ซึ่งจะมีท่อสำหรับเป่าลมร้อน"),
                MyBrewing("ชงกาแฟ 1 ช็อต ให้ได้ระดับน้ำ 1/3 ถ้วยกาแฟ"),
                MyBrewing("เทนมร้อน ลงไปอีก1/3 ถ้วยกาแฟ"),
                MyBrewing("ตักฟองนม เติมลงในถ้วยกาแฟให้พูนๆสวยงาม (ไม่ต้องล้นนะคะ)"),
                MyBrewing("โรยบนฟองนมด้วยผงอบเชยเล็กน้อย เป็นอันสำเร็จค่ะ")
            )
        }
        if(item == "ลาเต้"){
            _ingredientName.value = listOf(
                MyIngrediant("กาแฟสดแบบเมล็ดหรือแบบผง"),
                MyIngrediant("นมสดรสจืด"),
                MyIngrediant("ไซรัปกลิ่นต่างๆ"),
                MyIngrediant("น้ำตาลทราย")
            )
            _brewing.value = listOf(
                MyBrewing("Press กาแฟให้ได้ 2 Shot โดยใช้กาแฟ 1 Scoop หรือ 7-10 กรัม กับน้ำร้อนที่ 4 ออนซ์"),
                MyBrewing("ใส่นมลงไปให้ได้ 2 เท่าของกาแฟที่ได้"),
                MyBrewing("เใส่ไซรัป หรือน้ำตาลทราย"),
                MyBrewing("คนให้เข้ากัน")
            )
        }
        if(item == "มอคค่า"){
            _ingredientName.value = listOf(
                MyIngrediant("กาแฟเอสเปรสโซ่ 30 มิลลิลิตร"),
                MyIngrediant("ผงโกโก้ 1 ช้อนชา"),
                MyIngrediant("น้ำเชื่อม/นมข้นหวาน 1 ช้อนชา"),
                MyIngrediant("นมร้อน")
            )
            _brewing.value = listOf(
                MyBrewing("เทนมร้อนลงในแก้ว ใส่ผงโกโก้ คนให้เข้ากัน"),
                MyBrewing("เติมน้ำเชื่อมหรือนมข้นหวานลงไป"),
                MyBrewing("เทกาแฟเอสเปรสโซ่ลงไป (อาจจะบีบวิปครีมหรือใส่ฟองนมลงไปด้านบนเพิ่มก็ได้)")
            )
        }
        if(item == "เอสเพรสโซ่"){
            _ingredientName.value = listOf(
                MyIngrediant("เอสเปรสโซ่กลั่น 3 ออนซ์"),
                MyIngrediant("นมข้นหวาน 1 ออนซ์"),
                MyIngrediant("นมข้นจืด 1 ออนซ์"),
                MyIngrediant("นมสดสำหรับทำฟองนม")
            )
            _brewing.value = listOf(
                MyBrewing("กลั่นกาแฟให้ได้ 3 ออนซ์ หากใครไม่มีเครื่องทำกาแฟ ใช้กาแฟผง ประมาณ 2-3 ช้อนชา ชงกับน้ำร้อน 3 ออนซ์"),
                MyBrewing("นำกาแฟเอสเปรสโซ่ ผสมกับนมข้นหวาน นมข้นจืด คนให้เข้ากันจนเกิดฟองอากาศ (ออกแรงตีหน่อย)"),
                MyBrewing("ตักน้ำแข็งใสแก้ว เทกาแฟเอสเปรสโซ่ลงในแก้ว เกือบเต็ม"),
                MyBrewing("นำนมสดเย็นตีให้ขึ้นฟอง ตักฟองนมราดด้านบน")
            )
        }
        if(item == "อเมริกาโน่"){
            _ingredientName.value = listOf(
                MyIngrediant("ช็อตเอสเปรสโซ 1 ช็อต (30 ซีซี)"),
                MyIngrediant("น้ำร้อน 4 ออนซ์ (120 ซีซี)")
            )
            _brewing.value = listOf(
                MyBrewing("เติมน้ำร้อนเปล่าๆ ลงไปที่แก้วกาแฟ 4 ออนซ์"),
                MyBrewing("ด้วยช็อตเอสเปรสโซ 1 ช็อต ครีมม่า ที่เป็นฟองคล้ายฟองนมจะลอยอยู่ด้านบน")
            )
        }
        if(item == "ชานม"){
            _ingredientName.value = listOf(
                MyIngrediant("ผงชาไทย 5 ช้อนโต๊ะ"),
                MyIngrediant("น้ำต้มเดือด 2 1/2 ถ้วย"),
                MyIngrediant("น้ำตาลทราย 1/2 ถ้วย"),
                MyIngrediant("นมข้นหวาน 3 ช้อนโต๊ะ"),
                MyIngrediant("นมข้นจืด"),
                MyIngrediant("น้ำแข็ง")
            )
            _brewing.value = listOf(
                MyBrewing("ใส่ผงชาไทยลงในถุงกรองชาที่รองด้วยเหยือกสูงทนความร้อน จากนั้นเทน้ำร้อนใส่ลงไปจนท่วมใบชา เขย่าถุงกรองชาไปมาเพื่อให้ใบชาโดนน้ำจนทั่วแล้วพักทิ้งไว้ประมาณ 15 นาที"),
                MyBrewing("ใส่น้ำตาลทรายและนมข้นหวานลงในแก้วผสม เตรียมไว้"),
                MyBrewing("เครบ 15 นาที ขยับถุงชาเล็กน้อย จากนั้นยกขึ้นแล้วเทน้ำชาไทยที่กรองแล้วใส่ในน้ำตาลทรายคนให้เข้ากันจนละลาย พักทิ้งไว้ประมาณ 5-10 นาทีเพื่อให้เย็นลง"),
                MyBrewing("ใส่น้ำแข็งลงในแก้ว เทชาไทยลงไปประมาณ 3/4 ส่วน"),
                MyBrewing("เราดนมข้นจืดลงไป พร้อมเสิร์ฟ")
            )
        }
        if(item == "ชาเขียว"){
            _ingredientName.value = listOf(
                MyIngrediant("ผงชาเขียวตรามือ 4 ช้อนโต๊ะ"),
                MyIngrediant("น้ำร้อน 750 ml."),
                MyIngrediant("นมข้นหวาน ตามใจชอบ"),
                MyIngrediant("น้ำตาลทราย 2 ช้อนโต๊ะ"),
                MyIngrediant("นมสด"),
                MyIngrediant("น้ำแข็ง")
            )
            _brewing.value = listOf(
                MyBrewing("นำผงชาเขียวใส่ในถุงกรองชา แช่ในน้ำร้อน ประมาณ 3-5 นาที (อย่าแช่นาน ชาจะขม รสเฝื่อน) จะเหลือน้ำชาประมาณ 600 ml."),
                MyBrewing("ใส่น้ำตาลทรายลงไป คนให้ละลาย"),
                MyBrewing("เติมนมข้นหวานลงไปตามใจชอบ คนให้เข้ากัน"),
                MyBrewing("ตักน้ำแข็งใส่แก้ว ให้ล้นแก้วนิดหน่อย"),
                MyBrewing("ใส่นมสดลงไป 2/3 แก้ว หรือตามใจชอบ"),
                MyBrewing("เทน้ำชาเขียวลงไป")
            )
        }
        if(item == "ชามะลิ"){
            _ingredientName.value = listOf(
                MyIngrediant("ใบชาเขียวมะลิ 5 ช้อนชา"),
                MyIngrediant("น้ำเชื่อม อ่านต่อได้ที่"),
                MyIngrediant("น้ำหวานเฮลบลูบอยกลิ่นมะลิ"),
                MyIngrediant("น้ำเปล่า ")
            )
            _brewing.value = listOf(
                MyBrewing("ต้มน้ำให้เดือด ใส่ใบชาเขียว 5 ช้อนชาลงไป รอทิ้งไว้ 5 นาที"),
                MyBrewing("เมื่อแช่ใบชาครบ 5 นาที นำชาเทใส่แก้วตวง 6 oz ตามด้วยน้ำเชื่อม 1 ช้อนโต๊ะ ตามด้วยน้ำเชื่อมเฮลบลูบอยกลิ่นมะลิ 2 หยด เสร็จแล้วคนให้เข้ากัน"),
                MyBrewing("ทำซ้ำแบบเดิมจนกว่าใบชาจะต้มครบ 5 รอบหรือตามต้องการ แล้วเทใส่เหยือกเก็บไว้กินวันอื่นได้อีกหลายรอบ")
            )
        }
        if(item == "ชาดำ"){
            _ingredientName.value = listOf(
                MyIngrediant("ชาตรามือ หรือยี่ห้ออื่นก็ได้"),
                MyIngrediant("ถุงกรองชา แบบมีด้ามจับ หรือ ผ้าขาวบางก็ได้ เอาไว้กรองกากชา"),
                MyIngrediant("หม้อต้มน้ำ ขนาดเท่าที่ต้องการ 2 ใบ")
            )
            _brewing.value = listOf(
                MyBrewing("ตต้มน้ำ 1 หม้อ เมื่อน้ำเดือดแล้ว ยกหม้อลง"),
                MyBrewing("จากนั้น ตักผงชาตรามือใส่ในหม้อน้ำร้อนๆ ชาผง 1 ส่วน ต่อน้ำ 3 ส่วน"),
                MyBrewing("คนให้ชากับน้ำร้อนผสมเข้ากัน"),
                MyBrewing("เอาหม้ออีกใบมาวางเตรียมไว้ และ นำถุงกรองกากชามา หรือใช้ผ้าขาวบาง"),
                MyBrewing("เทชาจากหม้อใบแรกที่ชาผสมไว้ ลงบนถุงกรองกากชาหรือผ้าขาว เทกลับไปกลับมา 3-4 รอบ และแช่ทิ้งไว้ประมาณ 5 นาทีเพื่อให้ได้รสชาติของชาที่ฝาดนิดๆ")
            )
        }
        if(item == "ชามะนาว"){
            _ingredientName.value = listOf(
                MyIngrediant("ชาดำเย็น ที่ปรุงรสแล้ว"),
                MyIngrediant("มะนาว"),
                MyIngrediant("น้ำแข็ง")
            )
            _brewing.value = listOf(
                MyBrewing("หลังจากได้ชาดำที่ปรุงรสชาติแล้ว"),
                MyBrewing("บีบมะนาวใส่ลงไป แล้วชิมรสชาติ"),
                MyBrewing("เตรียมน้ำแข็งใส่อีกแก้ว แล้วเทชาลงไป ก็เป็นอันเสร็จ")
            )
        }
    }
}