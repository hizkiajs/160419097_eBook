package id.web.rpgfantasy.a160419097_hizkia.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Profile::class,Category::class, EBook::class], version = 2)
abstract class ELibDatabase:RoomDatabase() {
    abstract fun eBookDao():EBookDao
    abstract fun profileDao():ProfileDao
    abstract fun categoryDao():CategoryDao

    companion object {
        @Volatile private var instance:ELibDatabase? =null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,ELibDatabase::class.java,"ELibDatabase")
                .addMigrations()
                .build()

        operator fun invoke(context: Context){
            if(instance!=null){
                synchronized(LOCK){
                    instance ?: buildDatabase(context).also{
                        instance = it
                    }
                }
            }
        }
    }
}