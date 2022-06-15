package id.web.rpgfantasy.a160419097_hizkia.model

import com.google.gson.annotations.SerializedName
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Profile(
    @ColumnInfo(name = "id")
    var id: String?,
    @ColumnInfo(name = "nama")
    var nama: String?,
    @ColumnInfo(name = "tanggalLahir")
    var tanggalLahir: String?,
    @ColumnInfo(name = "jenisKelamin")
    var jenisKelamin: String?,
    @ColumnInfo(name = "email")
    var email: String?,
    @ColumnInfo(name = "noHP")
    var noHP: String?,
    @ColumnInfo(name = "photo")
    var photo: String?)

@Entity
data class EBook(
    @ColumnInfo(name = "id")
    var id: String?,
    @ColumnInfo(name = "nama")
    var nama: String?,
    @ColumnInfo(name = "editor")
    var editor: String?,
    @ColumnInfo(name = "publish")
    var publish: String?,
    @ColumnInfo(name = "copyright")
    var copyright: String?,
    @ColumnInfo(name = "about")
    var about: String?,
    @ColumnInfo(name = "author_bios")
    var author_bios: String?,
    @ColumnInfo(name = "review")
    var review: String?,
    @ColumnInfo(name = "photo")
    var photo: String?)