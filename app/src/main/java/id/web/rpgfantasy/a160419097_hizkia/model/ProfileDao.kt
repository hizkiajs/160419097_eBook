package id.web.rpgfantasy.a160419097_hizkia.model

import androidx.room.*

@Dao
interface ProfileDao{
    @Query("SELECT * FROM Profile")
    suspend fun selectProfile():List<Profile>

    @Query("SELECT * FROM Profile WHERE id = :id")
    suspend fun selectProfileById(id:Int):Profile

    @Delete
    suspend fun deleteProfile(profile: Profile)

    @Update
    suspend fun updateProfile(profile: Profile)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg profile:Profile)
}