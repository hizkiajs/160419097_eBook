package id.web.rpgfantasy.a160419097_hizkia.model

import androidx.room.*

@Dao
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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg eBook:EBook)
}
interface ProfileDao{
    @Query("SELECT * FROM Profile")
    suspend fun selectProfile():List<Profile>

    @Delete
    suspend fun deleteProfile(profile: Profile)

    @Query("UPDATE Profile SET nama = :name, tanggalLahir = :tanggalLahir, jenisKelamin = :jenisKelamin, email=:email, noHP=:noHP, photo=:photo, photo=:photo WHERE id =:idProfile")
    suspend fun update(name:String, tanggalLahir:String, jenisKelamin:String, email:String, noHP:String, photo:String, idProfile:Int )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg profile:Profile)
}
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