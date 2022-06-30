package id.web.rpgfantasy.a160419097_hizkia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import id.web.rpgfantasy.a160419097_hizkia.R
import id.web.rpgfantasy.a160419097_hizkia.databinding.FragmentAboutEBookBinding
import id.web.rpgfantasy.a160419097_hizkia.databinding.FragmentAuthorEBookBinding
import id.web.rpgfantasy.a160419097_hizkia.util.loadImage
import id.web.rpgfantasy.a160419097_hizkia.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_author_e_book.*
import kotlinx.android.synthetic.main.fragment_e_book_detail.*

/**
 * A simple [Fragment] subclass.
 * Use the [AuthorEBookFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AuthorEBookFragment : Fragment() {
    private lateinit var viewModel : DetailViewModel
    private lateinit var dataBinding: FragmentAuthorEBookBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_author_e_book, container, false )
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var id = ""
        arguments?.let {
            id = EBookDetailFragmentArgs.fromBundle(requireArguments()).idEBook
        }

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(id)

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.eBookDetailLiveData.observe(viewLifecycleOwner){
            dataBinding.eBook = it
        }
    }
}