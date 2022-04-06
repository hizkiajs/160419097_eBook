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

class DetailViewModel(application: Application) :AndroidViewModel(application) {
    val eBookDetailLiveData = MutableLiveData<EBook>()

    /*fun fetch() {
        studentLiveData.value = Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff")
    }*/

    val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun fetch(id: String) {
        queue = Volley.newRequestQueue(getApplication())
        var url = "https://gist.githubusercontent.com/hizkiajs/510dfb99e307ec5bf1cdfc5c5923d032/raw/ba572f14b082ec4287fa3fd030daf110f4ffb02a/ebook.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<ArrayList<EBook>>() {}.type
                val result = Gson().fromJson<ArrayList<EBook>>(it,sType)
                for (item in result){
                    if (id == item.id){
                        eBookDetailLiveData.value = item
                    }
                }
                Log.d("showVolley", result.toString())
            },
            {
                Log.d("errorVolley", it.toString())
            }
        ).apply {
            tag = "TAG"
        }
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}