package id.web.rpgfantasy.a160419097_hizkia.model

import androidx.room.*

@Dao
interface CategoryDao{
    @Query("SELECT * FROM Category")
    suspend fun selectAllCategory():List<Category>

    @Query("SELECT * FROM Category WHERE id = :id")
    suspend fun selectCategoryById(id:Int):List<Category>

    @Delete
    suspend fun deleteCategory(category: Category)

    @Query("UPDATE Category SET nama = :nama WHERE id =:idkategori")
    suspend fun update(nama:String, idkategori: Int )

    @Update
    suspend fun updateCategory(category: Category)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg category:Category)
}