package buu.informatics.s59160625.aunzcoffee.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DatabaseDao {
    @Insert
    fun insert(coffee: Coffee)

    @Update
    fun update(coffee: Coffee)

    @Query("SELECT * FROM coffee_table WHERE coffeeId = :key")
    fun  get(key: Long): Coffee

    @Query("DELETE FROM coffee_table")
    fun clear()

    @Query("SELECT * FROM coffee_table ORDER BY coffeeId DESC LIMIT 1")
    fun getLastCoffee(): Coffee?

    @Query("SELECT * FROM coffee_table ORDER BY coffeeId DESC")
    fun getAllCoffees(): LiveData<List<Coffee>>
}