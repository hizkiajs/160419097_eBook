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
import id.web.rpgfantasy.a160419097_hizkia.model.EBook
import id.web.rpgfantasy.a160419097_hizkia.model.Profile
import id.web.rpgfantasy.a160419097_hizkia.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class EBookViewModel(application: Application) :AndroidViewModel(application), CoroutineScope {
    val eBooksLiveData = MutableLiveData<List<EBook>>()
    val eBooksLoadErrorLiveData = MutableLiveData<Boolean>()
    val loadingLiveData = MutableLiveData<Boolean>()
    private var job = Job()

    fun refresh(){
        eBooksLoadErrorLiveData.value = false
        loadingLiveData.value = true
        launch {
            //val db = Room.databaseBuilder(getApplication(),TodoDatabase::class.java,"newtododb").build()
            val db = buildDb(getApplication())
            eBooksLiveData.value = db.eBookDao().selectAllEbook()
        }
    }


    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}