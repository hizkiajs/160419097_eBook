package id.web.rpgfantasy.a160419097_hizkia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import id.web.rpgfantasy.a160419097_hizkia.R
import id.web.rpgfantasy.a160419097_hizkia.databinding.FragmentEBookDetailBinding
import id.web.rpgfantasy.a160419097_hizkia.databinding.FragmentEditEBookBinding
import id.web.rpgfantasy.a160419097_hizkia.util.loadImage
import id.web.rpgfantasy.a160419097_hizkia.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_e_book_detail.*

/**
 * A simple [Fragment] subclass.
 * Use the [EBookDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EBookDetailFragment : Fragment(),NavigateToEditEbookListener{
    private lateinit var viewModel : DetailViewModel
    private lateinit var dataBinding :FragmentEBookDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_e_book_detail, container, false )
        return dataBinding.root

        //return inflater.inflate(R.layout.fragment_e_book_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var id = ""
        arguments?.let {
            id = EBookDetailFragmentArgs.fromBundle(requireArguments()).idEBook
        }
        dataBinding.navigateToEditEbookListener= this
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(id)

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.eBookDetailLiveData.observe(viewLifecycleOwner){
            dataBinding.eBook = it
            /*txtJudul.setText(it.nama)
            txtEditEditor.setText(it.editor)
            txtEditPublish.setText(it.publish)
            txtEditCopyright.setText(it.copyright)
            imgEBookDetailPhoto.loadImage(it.photo, progressLoadingDetailPhoto)
            var ideBook = it.id
            btnAbout.setOnClickListener {
                val action = EBookDetailFragmentDirections.actionEBookDetailFragmentToAboutEBookFragment(ideBook.toString())
                Navigation.findNavController(it).navigate(action)
            }

            btnAuthor.setOnClickListener {
                val action = EBookDetailFragmentDirections.actionEBookDetailFragmentToAuthorEBookFragment(ideBook.toString())
                Navigation.findNavController(it).navigate(action)
            }

            btnReviews.setOnClickListener {
                val action = EBookDetailFragmentDirections.actionEBookDetailFragmentToReviewEBookFragment(ideBook.toString())
                Navigation.findNavController(it).navigate(action)
            }*/
        }
    }

    override fun onNavigateToEditEbookListener(view: View) {
        var id = view.tag
        var action: NavDirections = EBookDetailFragmentDirections.actionEBookDetailFragmentToEditEBookFragment2(id.toString())
        Navigation.findNavController(view).navigate(action)
    }
}