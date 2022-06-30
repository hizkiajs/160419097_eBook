package id.web.rpgfantasy.a160419097_hizkia.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import id.web.rpgfantasy.a160419097_hizkia.R
import id.web.rpgfantasy.a160419097_hizkia.databinding.FragmentCreateCategoryBinding
import id.web.rpgfantasy.a160419097_hizkia.databinding.FragmentCreateEBookBinding
import id.web.rpgfantasy.a160419097_hizkia.model.Category
import id.web.rpgfantasy.a160419097_hizkia.model.EBook
import id.web.rpgfantasy.a160419097_hizkia.viewmodel.CategoryViewModel
import id.web.rpgfantasy.a160419097_hizkia.viewmodel.DetailViewModel
import id.web.rpgfantasy.a160419097_hizkia.viewmodel.EBookViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [CreateEBookFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateEBookFragment : Fragment(),EbookSaveListener {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentCreateEBookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_create_e_book, container, false)
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_create_e_book, container, false )
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        dataBinding.ebook = EBook("","","","","","","","",0,0)
        dataBinding.saveEbookListener = this


    }

    override fun onSaveEbookClicked(view: View, obj: EBook) {
        val list = listOf(obj)
        viewModel.addEbook(list)
    }

}