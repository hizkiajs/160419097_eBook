package id.web.rpgfantasy.a160419097_hizkia.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.web.rpgfantasy.a160419097_hizkia.R
import id.web.rpgfantasy.a160419097_hizkia.databinding.FragmentEditEBookBinding
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
class EditEBookFragment : Fragment(), EbookEditlistener {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding : FragmentEditEBookBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_edit_e_book, container, false)
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_edit_e_book, container, false )
        return dataBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        var id = ""
        arguments?.let {
            id = EditEBookFragmentArgs.fromBundle(requireArguments()).idEBook
        }
        //val uuid = EditEBookFragmentArgs.fromBundle(requireArguments()).idEBook
        dataBinding.eBookEditListener = this
        Log.d("uuid", id)
        viewModel.fetch(id)
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.eBookDetailLiveData.observe(viewLifecycleOwner) {
            dataBinding.eBook = it
            Log.d("isi dataBinding", dataBinding.eBook?.nama.toString())
        }
    }

    override fun onEditEbookClicked(view: View, obj: EBook) {
        //Log.d("berhasil" ,"masuk ke onEditEbookClicked")
        viewModel.update(obj)
        Toast.makeText(view.context, "EBook Updated.", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(view).popBackStack()
    }
}