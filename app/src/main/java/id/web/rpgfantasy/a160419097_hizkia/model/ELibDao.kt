package id.web.rpgfantasy.a160419097_hizkia.model

import androidx.room.*

interface EbookDao {
    @Query("SELECT * FROM Ebook")
    suspend fun selectAllEbook():List<EBook>

    @Query("SELECT * FROM Ebook WHERE category_id = :id")
    suspend fun selectEbookByCategory(id:Int):List<EBook>

    @Delete
    suspend fun deleteEbook(eBook: EBook)

    @Query("UPDATE Ebook SET nama = :name, editor = :editor, publish = :publish, copyright=:copyright, about=:about, author_bios=:bios, photo=:photo, category_id = :idkategori WHERE id =:idEbook")
    suspend fun update(name:String, editor:String,publish:String, copyright:String,about:String,bios:String, review:String, photo:String, idkategori:Int,idEbook:Int )

    @Update
    suspend fun updateEbook(eBook: EBook)
}
interface ProfileDao{

}
interface CategoryDao{

}