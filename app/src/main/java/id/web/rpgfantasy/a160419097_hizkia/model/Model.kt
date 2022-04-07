package id.web.rpgfantasy.a160419097_hizkia.model

import com.google.gson.annotations.SerializedName

data class Profile(var id: String?,
                   var nama: String?,
                   var tanggalLahir: String?,
                   var jenisKelamin: String?,
                   var email: String?,
                   var noHP: String?,
                   var photo: String?)

data class EBook(var id: String?,
                 var nama: String?,
                 var editor: String?,
                 var publish: String?,
                 var copyright: String?,
                 var about: String?,
                 var author_bios: String?,
                 var review: String?,
                 var photo: String?)