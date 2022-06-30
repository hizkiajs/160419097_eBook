package id.web.rpgfantasy.a160419097_hizkia.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.web.rpgfantasy.a160419097_hizkia.model.Category
import id.web.rpgfantasy.a160419097_hizkia.model.EBook
import id.web.rpgfantasy.a160419097_hizkia.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailViewModel(application: Application) :AndroidViewModel(application),CoroutineScope {
    val eBookDetailLiveData = MutableLiveData<EBook>()
    private var job = Job()

    fun fetch(id: String) {
        launch {
            //val db = Room.databaseBuilder(getApplication(),TodoDatabase::class.java,"newtododb").build()
            val db = buildDb(getApplication())
            eBookDetailLiveData.value = db.eBookDao().selectEbookById(id.toInt())
        }
    }
    fun addEbook(ebookList: List<EBook>){
        launch {
            //val db = Room.databaseBuilder(getApplication(), TodoDatabase::class.java,"newtododb").build()
            val db = buildDb(getApplication())
            db.eBookDao().insertAll(*ebookList.toTypedArray())
        }
    }
    fun update(eBook: EBook){
        launch {
            val db = buildDb(getApplication())
            db.eBookDao().updateEbook(eBook)
        }
    }
//    fun delete(id:String){
//        launch {
//            val db = buildDb(getApplication())
//            //db.eBookDao().safeDeleteEbook(id.toInt())
//        }
//    }


    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}