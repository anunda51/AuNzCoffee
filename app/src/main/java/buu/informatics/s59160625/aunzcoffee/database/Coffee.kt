package buu.informatics.s59160625.aunzcoffee.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coffee_table")
data class Coffee (
    @PrimaryKey(autoGenerate = true)
    var coffeeId: Long = 0L,

    @ColumnInfo(name = "coffee_name")
    var coffeeName: String = "Cappuccino"
)

