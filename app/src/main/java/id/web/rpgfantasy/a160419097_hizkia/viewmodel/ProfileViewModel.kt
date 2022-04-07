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

class ProfileViewModel(application: Application) :AndroidViewModel(application) {
    val profileLiveData = MutableLiveData<Profile>()

    /*fun fetch() {
        studentLiveData.value = Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff")
    }*/

    val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun fetch() {
        queue = Volley.newRequestQueue(getApplication())
        var url = "https://gist.githubusercontent.com/hizkiajs/888afdc8eb44a80b5371c46d8c8f819b/raw/9118c0781367388442a9e9976e37394cc17354be/profile.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {   response ->
                val result = Gson().fromJson<Profile>(response, Profile::class.java)
                profileLiveData.value = result
                Log.d("showVolley", response.toString())
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