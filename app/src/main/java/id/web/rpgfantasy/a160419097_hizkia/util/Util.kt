package id.web.rpgfantasy.a160419097_hizkia.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.room.Room
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import id.web.rpgfantasy.a160419097_hizkia.R
import id.web.rpgfantasy.a160419097_hizkia.model.ELibDatabase
import java.lang.Exception
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@BindingAdapter("imageUrl","progressBar")
fun loadImageFromUrl(view: ImageView, url: String?, pb: ProgressBar) {
    view.loadImage(url, pb)
}

@BindingAdapter("imageUrl")
fun loadImageFromUrl(view: ImageView, url: String?) {
    view.loadImage(url.toString())
}

fun ImageView.loadImage(url: String?, progressBar: ProgressBar) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_outline_24)
        .into(this, object: Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }

            override fun onError(e: Exception?) { }
        })
}

fun ImageView.loadImage(url: String) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_outline_24)
        .into(this, object: Callback {
            override fun onSuccess() {}

            override fun onError(e: Exception?) { }
        })
}

val DB_NAME = "ELibDatabase"
fun buildDb(context: Context):ELibDatabase{
    val db = Room.databaseBuilder(context,ELibDatabase::class.java, DB_NAME)
        .addMigrations(MIGRATION_1_2)
        .build()
    return db
}

val MIGRATION_1_2= object  :Migration(1,2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE EBook ADD COLUMN deleted INTEGER DEFAULT 0 not null")
    }

}

