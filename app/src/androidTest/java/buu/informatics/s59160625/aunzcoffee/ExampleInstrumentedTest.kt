package buu.informatics.s59160625.aunzcoffee

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import buu.informatics.s59160625.aunzcoffee.database.Coffee
import buu.informatics.s59160625.aunzcoffee.database.CoffeeDatabase
import buu.informatics.s59160625.aunzcoffee.database.CoffeeDatabaseDao
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private lateinit var dao: CoffeeDatabaseDao
    private lateinit var db: CoffeeDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory coffeeDatabase because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, CoffeeDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        dao = db.coffeeDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetCoffee() {
        val night = Coffee()
        dao.insert(night)
        val coffee = dao.getLastCoffee()
        assertEquals(coffee?.coffeeName, "Cappuccino")
    }
}
