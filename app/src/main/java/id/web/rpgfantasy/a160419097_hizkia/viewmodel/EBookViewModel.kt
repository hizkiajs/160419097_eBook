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
import id.web.rpgfantasy.a160419097_hizkia.model.Profile

class EBookViewModel(application: Application) :AndroidViewModel(application) {
    val eBooksLiveData = MutableLiveData<ArrayList<Profile>>()
    val eBooksLoadErrorLiveData = MutableLiveData<Boolean>()
    val loadingLiveData = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh(){
        /*studentsLiveData.value = arrayListOf(
            Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff"),
            Student("13312","Rich","1994/12/14","3925444073","http://dummyimage.com/75x100.jpg/5fa2dd/ffffff"),
            Student("11204","Dinny","1994/10/07","6827808747","http://dummyimage.com/75x100.jpg/5fa2dd/ffffff1")
        )*/
        eBooksLoadErrorLiveData.value = false
        loadingLiveData.value = true

        queue = Volley.newRequestQueue(getApplication())
        var url = "https://gist.githubusercontent.com/hizkiajs/888afdc8eb44a80b5371c46d8c8f819b/raw/660c192b80589d4f2447e290eaa630c13bddbe51/profile.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val sType = object : TypeToken<ArrayList<Profile>>() { }.type
                val result = Gson().fromJson<ArrayList<Profile>>(response, sType)
                eBooksLiveData.value = result
                loadingLiveData.value = false
                Log.d("showvolley", response.toString())
            },
            {
                loadingLiveData.value = false
                eBooksLoadErrorLiveData.value = true
                Log.d("errorvolley", it.toString())
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