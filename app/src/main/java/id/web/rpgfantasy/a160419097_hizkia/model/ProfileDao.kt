package id.web.rpgfantasy.a160419097_hizkia.model

import androidx.room.*

@Dao
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