package id.web.rpgfantasy.a160419097_hizkia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.web.rpgfantasy.a160419097_hizkia.R

/**
 * A simple [Fragment] subclass.
 * Use the [AboutEBookFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutEBookFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_e_book, container, false)
    }
}