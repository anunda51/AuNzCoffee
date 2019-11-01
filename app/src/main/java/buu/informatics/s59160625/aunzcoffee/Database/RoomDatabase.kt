package buu.informatics.s59160625.aunzcoffee.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Coffee::class], version = 1, exportSchema = false)
abstract class RoomDatabase: RoomDatabase() {

    abstract val databaseDao: DatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDatabase? = null

        fun getInstance(context: Context): RoomDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RoomDatabase::class.java,
                        "sleep_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}