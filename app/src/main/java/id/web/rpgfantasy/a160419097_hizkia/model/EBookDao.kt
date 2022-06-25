package id.web.rpgfantasy.a160419097_hizkia.model

import androidx.room.*

@Dao
interface EBookDao {
    @Query("SELECT * FROM Ebook Where deleted = 0")
    suspend fun selectAllEbook():List<EBook>

    @Query("SELECT * FROM Ebook WHERE id = :id")
    suspend fun selectEbookById(id:Int):EBook

    @Query("SELECT * FROM Ebook WHERE category_id = :id")
    suspend fun selectEbookByCategory(id:Int):List<EBook>

    @Query("UPDATE Ebook SET deleted = 1 WHERE id =:id ")
    suspend fun safeDeleteEbook(id:Int)

    @Delete
    suspend fun deleteEbook(eBook: EBook)

//    @Query("UPDATE Ebook SET nama = :name, editor = :editor, publish = :publish, copyright=:copyright, about=:about, author_bios=:bios, photo=:photo, category_id = :idkategori WHERE id =:idEbook")
//    suspend fun update(name:String, editor:String,publish:String, copyright:String,about:String,bios:String, review:String, photo:String, idkategori:Int,idEbook:Int )

    @Update
    suspend fun updateEbook(eBook: EBook)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg eBook:EBook)
}