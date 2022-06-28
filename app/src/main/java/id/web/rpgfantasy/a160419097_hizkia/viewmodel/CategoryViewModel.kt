package id.web.rpgfantasy.a160419097_hizkia.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.web.rpgfantasy.a160419097_hizkia.model.Category
import id.web.rpgfantasy.a160419097_hizkia.model.EBook
import id.web.rpgfantasy.a160419097_hizkia.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CategoryViewModel(application: Application) :AndroidViewModel(application), CoroutineScope {
    val eCategoryDetailLiveData = MutableLiveData<Category>()
    private var job = Job()

    fun addCategory(categoryList: List<Category>){
        launch {
            //val db = Room.databaseBuilder(getApplication(), TodoDatabase::class.java,"newtododb").build()
            val db = buildDb(getApplication())
            db.categoryDao().insertAll(*categoryList.toTypedArray())
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

}