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
import androidx.navigation.Navigation
import id.web.rpgfantasy.a160419097_hizkia.R
import id.web.rpgfantasy.a160419097_hizkia.databinding.FragmentCreateCategoryBinding
import id.web.rpgfantasy.a160419097_hizkia.model.Category
import id.web.rpgfantasy.a160419097_hizkia.viewmodel.CategoryViewModel
import kotlinx.android.synthetic.main.fragment_create_category.*
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 * Use the [CreateCategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateCategoryFragment : Fragment(),CategorySaveListener {
    private lateinit var viewModel:CategoryViewModel
    private lateinit var dataBinding: FragmentCreateCategoryBinding

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
//        return inflater.inflate(R.layout.fragment_create_category, container, false)
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_create_category, container, false )
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
        dataBinding.category = Category("")
        dataBinding.saveListener = this

    }

    override fun onSaveCategoryClicked(view: View, obj: Category) {
        val list = listOf(obj)
        viewModel.addCategory(list)
        Toast.makeText(view.context, "Category Created.", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(view).popBackStack()
        Log.d("category",obj.nama.toString() );
    }
}