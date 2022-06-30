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

class ProfileViewModel(application: Application) :AndroidViewModel(application),CoroutineScope {
    val profileLiveData = MutableLiveData<Profile>()
    private var job = Job()

    /*fun fetch() {
        studentLiveData.value = Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff")
    }*/

    fun fetch(id: String) {
       launch {
           val db = buildDb(getApplication())
           profileLiveData.value = db.profileDao().selectProfileById(id.toInt())
       }
    }

    fun addProfile(profileList: List<Profile>){
        launch {
            //val db = Room.databaseBuilder(getApplication(), TodoDatabase::class.java,"newtododb").build()
            val db = buildDb(getApplication())
            db.profileDao().insertAll(*profileList.toTypedArray())
        }
    }

    fun update(profile: Profile){
        launch {
            val db = buildDb(getApplication())
            db.profileDao().updateProfile(profile)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}