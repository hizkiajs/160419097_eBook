package id.web.rpgfantasy.a160419097_hizkia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.web.rpgfantasy.a160419097_hizkia.R
import id.web.rpgfantasy.a160419097_hizkia.model.EBook
import id.web.rpgfantasy.a160419097_hizkia.view.AboutEBookFragmentArgs.Companion.fromBundle
import id.web.rpgfantasy.a160419097_hizkia.view.EBookDetailFragmentArgs.Companion.fromBundle
import id.web.rpgfantasy.a160419097_hizkia.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_author_e_book.*
import kotlinx.android.synthetic.main.fragment_create_e_book.*
import kotlinx.android.synthetic.main.fragment_edit_e_book.*


/**
 * A simple [Fragment] subclass.
 * Use the [EditEBookFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditEBookFragment : Fragment(), EbookEditListener {
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_e_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        val uuid = EditEBookFragmentArgs.fromBundle(requireArguments()).idEBook

        viewModel.fetch(uuid)
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.eBookDetailLiveData.observe(viewLifecycleOwner) {
            txtEditNama.setText(it.nama)
            txtEditEditor.setText(it.editor)
            txtEditPublish.setText(it.publish)
            txtCopyright.setText(it.copyright)
            txtEditAbout.setText(it.about)
            txtAuthoBios.setText(it.author_bios)
            txtEditReview.setText(it.review)
            txtEditPhoto.setText(it.photo)
            txtEditCategory.setText(it.category_id.toString())
        }
    }

    override fun OnEditEbookClicked(view: View, obj: EBook) {
        viewModel.update(obj)
        Toast.makeText(view.context, "EBook Updated.", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(view).popBackStack()
    }
}