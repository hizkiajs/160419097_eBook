package id.web.rpgfantasy.a160419097_hizkia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import id.web.rpgfantasy.a160419097_hizkia.R
import id.web.rpgfantasy.a160419097_hizkia.databinding.FragmentEBookDetailBinding
import id.web.rpgfantasy.a160419097_hizkia.databinding.FragmentHomeBinding
import id.web.rpgfantasy.a160419097_hizkia.model.Category
import id.web.rpgfantasy.a160419097_hizkia.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), NavigateToListEbookListener, NavigateToNewEbookListener, NavigateToNewCategoryListener, NavigateToNewProfileListener {
    private lateinit var dataBinding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false )
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /*btnListeBook.setOnClickListener {
            val action = HomeFragmentDirections.actionItemHomeToEBookListFragment()
            Navigation.findNavController(it).navigate(action)
        }
        btnAddNewEBook.setOnClickListener {
            val action = HomeFragmentDirections.actionItemHomeToCreateEBookFragment()
            Navigation.findNavController(it).navigate(action)
        }
        btnAddNewCategory.setOnClickListener {
            val action = HomeFragmentDirections.actionItemHomeToCreateCategoryFragment()
            Navigation.findNavController(it).navigate(action)
        }
        btnAddNewProfile.setOnClickListener{
            val action = HomeFragmentDirections.actionItemHomeToCreateProfileFragment()
            Navigation.findNavController(it).navigate(action)
        }*/
        dataBinding.navigateToListEbookListener = this
        dataBinding.navigateToNewCategoryListener = this
        dataBinding.navigateToNewEbookListener = this
        dataBinding.navigateToNewProfileListener = this

    }

    override fun onNavigateToListEbookListener(view: View) {
        val action = HomeFragmentDirections.actionItemHomeToEBookListFragment()
        Navigation.findNavController(view).navigate(action)
    }

    override fun onNavigateToNewEbookListener(view: View) {
        val action = HomeFragmentDirections.actionItemHomeToCreateEBookFragment()
        Navigation.findNavController(view).navigate(action)
    }

    override fun onNavigateToNewCategoryListener(view: View) {
        val action = HomeFragmentDirections.actionItemHomeToCreateCategoryFragment()
        Navigation.findNavController(view).navigate(action)
    }

    override fun onNavigateToNewProfileListener(view: View) {
        val action = HomeFragmentDirections.actionItemHomeToCreateProfileFragment()
        Navigation.findNavController(view).navigate(action)
    }

}