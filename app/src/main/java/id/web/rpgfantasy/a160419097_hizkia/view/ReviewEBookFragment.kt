package id.web.rpgfantasy.a160419097_hizkia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import id.web.rpgfantasy.a160419097_hizkia.R
import id.web.rpgfantasy.a160419097_hizkia.util.loadImage
import id.web.rpgfantasy.a160419097_hizkia.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_about_e_book.*
import kotlinx.android.synthetic.main.fragment_review_e_book.*

/**
 * A simple [Fragment] subclass.
 * Use the [ReviewEBookFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReviewEBookFragment : Fragment() {
    private lateinit var viewModel : DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review_e_book, container, false)
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
            txtContentReview.setText(it.review)
            imgEBookReviewPhoto.loadImage(it.photo)
        }
    }
}